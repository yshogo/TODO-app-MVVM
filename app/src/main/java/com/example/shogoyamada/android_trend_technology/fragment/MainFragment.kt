package com.example.shogoyamada.android_trend_technology.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.adapter.RecyclerAdapter
import com.example.shogoyamada.android_trend_technology.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val list = ArrayList<UserViewModel>()

        for (i in 1..10) {
            val viewModel = UserViewModel("shogo yamada", "24歳")
            list.add(viewModel)
        }

        val adapter = RecyclerAdapter(activity, list)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }
}
