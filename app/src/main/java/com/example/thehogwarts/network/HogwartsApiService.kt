package com.example.thehogwarts.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.mmobomb.com/api1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HogwartsApiService {
    @GET("games?sort-by=alphabetical")
    suspend fun getCharacters(): List<Characters>
}

object CharactersApi {
    val retrofitService : HogwartsApiService by lazy {
        retrofit.create(HogwartsApiService::class.java) }
}
