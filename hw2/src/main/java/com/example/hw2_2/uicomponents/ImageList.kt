package com.example.hw2_2.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2_2.model.ImageData
import com.example.hw2_2.model.ImageListFactory

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageList: MutableList<ImageData>
) {

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        imageList.forEach { imageData ->
            if(imageData.isChecked) {
                An_Image(resID = imageData.resID)
            }
        }
    }
    
}

@Preview
@Composable
private fun ImageListPreview() {
    ImageList(imageList =  ImageListFactory.getImageList())

}