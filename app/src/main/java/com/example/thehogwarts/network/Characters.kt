package com.example.thehogwarts.network

data class Characters (
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
//    @Json(name = "img_src") val imgSrcUrl: String
)