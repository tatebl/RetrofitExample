package com.example.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class LawyersReturned (    //what receiving back from server - login successful or access failed
    //need this token every time you access server
    //usually saved to shared preferences and preserved over the life of the app
    @SerializedName("accessToken") val accessToken:String     //will convert to JSON

)