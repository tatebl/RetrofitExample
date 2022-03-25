package com.example.retrofitexample.network.repository

import com.example.retrofitexample.network.Lawyer
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

import retrofit2.http.GET

interface LawyersAPIService {

    @GET("lawyers")
    suspend fun getLawyerList(): Response<List<Lawyer>>
}