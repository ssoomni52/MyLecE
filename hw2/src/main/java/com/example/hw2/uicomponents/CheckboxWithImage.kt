package com.example.hw2.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2.R
import com.example.hw2.model.CheckboxItem

@Composable
fun CheckboxWithImage(itemList: MutableList<CheckboxItem>, modifier: Modifier = Modifier) {

    val itemListSaver = listSaver<List<CheckboxItem>, List<Any>>(
        save = { item ->
            item.map { mutableListOf(it.img, it.label, it.isChecked) }
        },
        restore = { savedList ->
            savedList.map {
                val item = it as MutableList<Any>
                CheckboxItem(item[0] as Int, item[1] as String, item[2] as Boolean)
            }

        }
    )

    var items by rememberSaveable(stateSaver = itemListSaver) {
        mutableStateOf(itemList)
    }

    val displayContent: @Composable () -> Unit = {
        Box {
            items.forEach { item ->
                if (item.isChecked) {
                    Image(
                        painter = painterResource(id = item.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(400.dp)
                    )
                }
            }
        }

        Column (
        ){
            items.forEachIndexed { index, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(30.dp)
                ) {
                    Checkbox(checked = item.isChecked, onCheckedChange = { isChecked ->
                        val newItemList = items.toMutableList()
                        newItemList[index] = item.copy(isChecked = isChecked)
                        items = newItemList
                    })
                    Text(text = item.label, fontWeight = FontWeight.Bold)
                }
            }
        }


    }


    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column {
            displayContent()
        }
    } else {
        Row (){
            displayContent()
        }
    }


//    Column (
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        Box {
//            items.forEach { item ->
//                if (item.isChecked) {
//                    Image(
//                        painter = painterResource(id = item.img),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(400.dp)
//                    )
//                }
//            }
//        }
//
//
//        items.forEachIndexed { index, item ->
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()
//            ){
//                Checkbox(checked = item.isChecked, onCheckedChange = { isChecked ->
//                    val newItemList = items.toMutableList()
//                    newItemList[index] = item.copy(isChecked = isChecked)
//                    items = newItemList
//                })
//                Text(text = item.label, fontWeight = FontWeight.Bold)
//            }
//        }
//
//
//    }


}


@Preview(device = "spec:width=411dp,height=891dp")
@Preview(device = "spec:width=1280dp,height=800dp,dpi=480")
@Composable
private fun CheckboxWithImagePreview() {

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

