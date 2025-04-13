package com.example.hw2_2.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun A_Checkbox(
    Checked: Boolean,
    resName: String,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically){
        Checkbox(checked = Checked, onCheckedChange = {checked -> onCheckedChange(checked)})
        Text(text = resName)
    }

}

@Preview
@Composable
private fun A_CheckboxPreview() {
    A_Checkbox(
        Checked = true,
        resName = "preview"
    ) { }
}