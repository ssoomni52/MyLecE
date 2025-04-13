package com.example.hw2_2.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2_2.model.ImageData
import com.example.hw2_2.model.ImageListFactory

@Composable
fun CheckboxList(
    modifier: Modifier = Modifier,
    imageList: MutableList<ImageData>
) {

    /* TODO : Make CheckboxList 2by5 ???*/
//    Column {
//        imageList.forEachIndexed { index, imageData ->
//            if(index > 0) {
//                A_Checkbox(
//                    Checked = imageData.isChecked,
//                    resName = imageData.resName
//                ) {
//                    imageList[index] = imageData.copy(isChecked = it)
//                }
//            }
//        }
//    }


    Row {
        Column {
            imageList.forEachIndexed { index, imageData ->
                if (index > 0 && index < 6) {
                    A_Checkbox(
                        Checked = imageData.isChecked,
                        resName = imageData.resName
                    ) {
                        imageList[index] = imageData.copy(isChecked = it)
                    }
                }

            }
        }

        Column {
            imageList.forEachIndexed{ index, imageData ->
                if(index > 5)
                A_Checkbox(
                    Checked = imageData.isChecked,
                    resName = imageData.resName
                ) {
                    imageList[index] = imageData.copy(isChecked = it)
                }
            }
        }

    }


}

@Preview
@Composable
private fun CheckboxListPreview() {
    CheckboxList(imageList = ImageListFactory.getImageList())
}