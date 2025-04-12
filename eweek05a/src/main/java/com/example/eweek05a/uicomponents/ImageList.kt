package com.example.eweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.viewmodel.ImageViewModel

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageList: MutableList<ImageData>
) {
    imageList.forEachIndexed { index, imageData ->
        when (imageData.buttonType) {
            ButtonType.ICON -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithIcon(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }
            ButtonType.BADGE -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithBadge(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }

            ButtonType.EMOJI -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithEmoji(
                        likes = imageData.likes,
                        dislikes = imageData.dislikes,
                        onClickLikes = {
                            imageList[index] = imageData.copy(likes = imageData.likes + 1)
                        },
                        onClickDisLikes = {
                            imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                        })
                }
            }
        }
    }
}


@Preview
@Composable
private fun ImageListPreview() {

    var scrollState = rememberScrollState()

    val imageViewModel: ImageViewModel = viewModel()
    var imageList = imageViewModel.imageList

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageList(imageList = imageList)
    }
}