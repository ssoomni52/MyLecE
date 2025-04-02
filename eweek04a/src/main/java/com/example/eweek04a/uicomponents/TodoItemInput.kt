package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.Item
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember { mutableStateOf("") } //remember : state를 기억하고 있다.


    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            TextField(
                value = textFieldState,
                onValueChange = { text:String -> textFieldState = text },
                placeholder = { Text("할 일을 입력하세요.") }
            )
            Button(onClick = {
                // 3/31 까지 완성 해와라
                val currentTime = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
                todoList.add(Item(textFieldState, currentTime))
                textFieldState = "" // input창 초기화
            }) {
                Text("추가")
            }

        }

//        // onClick 테스트
//        LazyColumn {
//            items(todoList) { item ->
//                Text(text = item.content)
//                Text(text = item.time)
//            }
//        }
    }


}

@Preview
@Composable
fun TodoItemInputPreview() {
    TodoItemInput(todoList = remember { mutableStateListOf<Item>() })
}
