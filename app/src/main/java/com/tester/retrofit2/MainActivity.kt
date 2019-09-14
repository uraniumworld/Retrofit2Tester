package com.tester.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.scalars.ScalarsConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///////////////////////
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val service = retrofit.create<MyService>(MyService::class.java)
        val request = service.getData("todos")
        Log.d("xmuz request",request.request().url().toString())
        request.enqueue(object:Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
            }
            override fun onResponse(call: Call<String>, response: Response<String>) {
                 Log.d("xmuz response",response.body().toString())
            }
        })
    }
}
