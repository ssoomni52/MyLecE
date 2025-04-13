package com.example.hw2_2.model

import androidx.compose.runtime.mutableStateListOf
import com.example.hw2_2.R

object ImageListFactory {

    fun getImageList() = mutableStateListOf(

        // Body는 항상 보여야 함
        ImageData(resID = R.drawable.body, resName = "body"),
        ImageData(resID = R.drawable.arms, resName = "arms"),
        ImageData(resID = R.drawable.ears, resName = "ears"),
        ImageData(resID = R.drawable.eyebrows, resName = "eyebrows"),
        ImageData(resID = R.drawable.eyes, resName = "eyes"),
        ImageData(resID = R.drawable.glasses, resName = "glasses"),
        ImageData(resID = R.drawable.hat, resName = "hat"),
        ImageData(resID = R.drawable.mouth, resName = "mouth"),
        ImageData(resID = R.drawable.mustache, resName = "mustache"),
        ImageData(resID = R.drawable.nose, resName = "nose"),
        ImageData(resID = R.drawable.shoes, resName = "shoes"),
    )



}