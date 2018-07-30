package com.example.shogoyamada.android_trend_technology.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.adapter.RecyclerAdapter
import com.example.shogoyamada.android_trend_technology.service.UserInfoService
import com.example.shogoyamada.android_trend_technology.service.Users
import com.example.shogoyamada.android_trend_technology.viewModel.UserViewModel
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit.MoshiConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val moshi = Moshi.Builder()
                .build()
        val retrofit = Retrofit
                .Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory((MoshiConverterFactory.create(moshi)))
                .baseUrl("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/")
                .build()

        retrofit.create(UserInfoService::class.java)
                .listUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Users>() {
                    override fun onNext(list: Users?) {
                        if (list != null) {
                            setAdapter(UserViewModel.convertFromUsertoViewModel(list))
                        }
                    }

                    override fun onCompleted() {
                        print("COM")
                    }

                    override fun onError(e: Throwable?) {
                        print(e)
                    }
                })
    }


    private fun setAdapter(list: ArrayList<UserViewModel>) {
        val adapter = RecyclerAdapter(activity, list)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }
}
