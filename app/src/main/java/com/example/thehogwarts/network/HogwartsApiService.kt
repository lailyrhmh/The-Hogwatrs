package com.example.thehogwarts.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://hp-api.herokuapp.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface HogwartsApiService {
//    @GET("characters")
//    suspend fun getCharacters(): String
}

object MarsApi {
    val retrofitService : HogwartsApiService by lazy {
        retrofit.create(HogwartsApiService::class.java) }
}
