package com.example.retrofitexample.network.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create
import java.util.concurrent.TimeUnit


//new>object

object RetrofitHelper {

    private var retrofit: Retrofit

    init {
        val builder=Retrofit.Builder()
            .baseUrl("https://private-31e6f8b-lawyersearchapi.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())



        val loggingInterceptor=HttpLoggingInterceptor()
        loggingInterceptor.level=HttpLoggingInterceptor.Level.BODY

        val okHttpClient=OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0, TimeUnit.MICROSECONDS)
            .writeTimeout(2,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES).build()

        retrofit=builder.client(okHttpClient).build()
    }

    fun getLawyerService():LawyersAPIService {
        return retrofit.create(LawyersAPIService::class.java)
    }


}