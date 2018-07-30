package com.example.shogoyamada.android_trend_technology.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.android_trend_technology.R
import com.example.shogoyamada.android_trend_technology.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().replace(android.R.id.content, MainFragment()).commitAllowingStateLoss()
    }
}
