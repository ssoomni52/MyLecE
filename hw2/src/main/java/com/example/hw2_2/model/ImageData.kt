package com.example.hw2_2.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val resID: Int,
    val resName: String,
    var isChecked: Boolean = true
) {

    companion object {
        val ImageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    item.resID,
                    item.resName,
                    item.isChecked,
                )
            },

            restore = { list ->
                ImageData(
                    resID = list[0] as Int,
                    resName = list[1] as String,
                    isChecked = list[2] as Boolean
                )
            }
        )

    }


}
