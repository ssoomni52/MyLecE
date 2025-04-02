package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val showPendingOnly = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        TodoSwitch(checked = showPendingOnly.value) { isChecked ->
            showPendingOnly.value = isChecked
        }

        todoList.forEachIndexed { index, item ->
            // ShowPendingOnly 이고 TodoState.Completed 인 경우만 막으면 됨
            if(!(showPendingOnly.value && item.status == TodoStatus.COMPLETED)) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 10.dp)
                ) {
                    Row {
                        TodoCheckbox(checked = (item.status == TodoStatus.COMPLETED)) { isChecked ->
//                        // 아래 같이 일부 속성만 바뀌면 감지 못함
//                        todoList[index].status = if (isChecked) TodoStatus.COMPLETED else TodoStatus.PENDING
                            todoList[index] = item.copy(
                                status = if (isChecked) TodoStatus.COMPLETED else TodoStatus.PENDING
                            )
                        }
                        TodoItem(item = item)
                    }
                }
            }
        }
    }

}


@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())

}