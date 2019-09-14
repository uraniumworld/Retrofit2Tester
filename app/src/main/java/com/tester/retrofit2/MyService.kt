package com.tester.retrofit2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MyService {
    @GET("/{data}")
    fun getData(@Path("data") data: String): Call<String>
}