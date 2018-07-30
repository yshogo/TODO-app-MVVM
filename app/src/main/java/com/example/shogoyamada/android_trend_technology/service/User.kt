package com.example.shogoyamada.android_trend_technology.service

import java.io.Serializable

data class Users(val users: List<User>): Serializable

data class User(val user: UserInfo): Serializable

data class UserInfo(val user_name: String, val age: Int): Serializable