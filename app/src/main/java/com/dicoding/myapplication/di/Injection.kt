package com.dicoding.myapplication.di

import android.content.Context
import com.dicoding.myapplication.data.preference.UserPreference
import com.dicoding.myapplication.data.UserRepository
import com.dicoding.myapplication.data.preference.dataStore


object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}