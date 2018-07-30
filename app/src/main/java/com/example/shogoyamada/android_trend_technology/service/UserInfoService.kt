package com.example.shogoyamada.android_trend_technology.service

import retrofit.http.GET
import rx.Observable

interface UserInfoService {

    @GET("document.json?alt=media&token=bbb01879-7c49-4c98-a815-00edae754d04")
    fun listUser(): Observable<Users>
}