package com.example.eweek05a.model

// sealed 상속받
sealed class ImageUri {
    data class ResImage(val resID: Int): ImageUri()
    data class WebImage(val webUrl: String): ImageUri()



}