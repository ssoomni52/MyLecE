package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {


    val imageList = imageViewModel.imageList
    var scrollState = rememberScrollState()


    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        // 세로 모드
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }


    } else {
        // 가로 모드
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }

    }


//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//
//    }
//
//    var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 0,
//                dislikes = 0
//            )
//        )
//    }
//
//    var img3State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img3),
//                buttonType = ButtonType.ICON,
//                likes = 0,
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                // 일부 속성만 바뀐다고 state 변하는게 아님
//                // 복사해라
//                img1State = img1State.copy(likes = img1State.likes+1)
//            }
//        }
//
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {img2State = img2State.copy(likes = img2State.likes+1)},
//                onClickDisLikes = {img2State = img2State.copy(dislikes = img2State.dislikes+1)}
//            )
//        }
//
//
//
//    }


}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}