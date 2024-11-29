package com.dicoding.myapplication.data.preference

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)