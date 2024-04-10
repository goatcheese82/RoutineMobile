package com.example.routine.network

import com.example.routine.api.MyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://schedule-vb72.onrender.com"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideApiService(): MyApiService {
        return retrofit.create(MyApiService::class.java)
    }
}