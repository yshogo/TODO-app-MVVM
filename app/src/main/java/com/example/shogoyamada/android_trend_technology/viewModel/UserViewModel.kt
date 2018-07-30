package com.example.shogoyamada.android_trend_technology.viewModel

import android.databinding.BaseObservable
import com.example.shogoyamada.android_trend_technology.service.Users

data class UserViewModel(val name: String, val age: String) : BaseObservable() {

    companion object {
        fun convertFromUsertoViewModel(list: Users): ArrayList<UserViewModel> {

            val viewModelList = ArrayList<UserViewModel>()
            for (model in list.users) {
                viewModelList.add(UserViewModel(model.user.user_name, model.user.age.toString() + "歳"))
            }

            return viewModelList
        }
    }
}