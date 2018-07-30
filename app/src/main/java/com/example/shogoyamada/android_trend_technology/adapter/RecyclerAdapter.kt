package com.example.shogoyamada.android_trend_technology.adapter

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.viewModel.UserViewModel


class RecyclerAdapter(activity: AppCompatActivity, private val list: ArrayList<UserViewModel>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(activity);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.recycle_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}