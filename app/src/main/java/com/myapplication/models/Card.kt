package com.myapplication.models

data class Card (
    var title: String = "",
    var category: String = "",
    var writer: String = "",
    var price: String = "",
    val image: Int,
    var context: String = "",
    var option: Boolean )

