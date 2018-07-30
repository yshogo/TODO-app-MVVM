package com.example.shogoyamada.android_trend_technology.adapter

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR.user
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.viewModel.UserViewModel


class RecyclerAdapter(activity: Activity, private val list: ArrayList<UserViewModel>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(activity)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.recycle_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = list[position]
        holder.binding?.setVariable(user, viewModel)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewDataBinding>(view)
    }
}