package com.example.shogoyamada.android_trend_technology.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.databinding.ActivityMainBinding
import com.example.shogoyamada.android_trend_technology.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val model = UserViewModel("Shogo Yamada", 22)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = model
    }
}
