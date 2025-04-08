package com.example.hw2.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2.R
import com.example.hw2.model.CheckboxItem

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val itemList = mutableListOf(
        CheckboxItem(img = R.drawable.arms, label = "arm", isChecked = true),
        CheckboxItem(img = R.drawable.ears, label = "ears", isChecked = true),
        CheckboxItem(img = R.drawable.eyebrows, label = "eyebrows", isChecked = true),
        CheckboxItem(img = R.drawable.eyes, label = "eyes", isChecked = true),
        CheckboxItem(img = R.drawable.glasses, label = "glasses", isChecked = true),
        CheckboxItem(img = R.drawable.hat, label = "hat", isChecked = true),
        CheckboxItem(img = R.drawable.mouth, label = "mouth", isChecked = true),
        CheckboxItem(img = R.drawable.mustache, label = "mustache", isChecked = true),
        CheckboxItem(img = R.drawable.nose, label = "nose", isChecked = true),
        CheckboxItem(img = R.drawable.shoes, label = "shoes", isChecked = true),
    )

    CheckboxWithImage(itemList = itemList)
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}