package com.example.project136.Domains

import java.io.Serializable

class PopularDomain(
    var title: String,
    var location: String,
    var description: String,
    var bed: Int,
    var isGuide: Boolean,
    var score: Double,
    var pic: String,
    var isWifi: Boolean,
    var price: Int,
    var bookingUrl: String
) : Serializable
