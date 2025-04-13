package com.example.hw2_2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hw2_2.model.ImageData
import com.example.hw2_2.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = ImageListFactory.getImageList()

    val imageList: MutableList<ImageData>
        get() = _imageList


}