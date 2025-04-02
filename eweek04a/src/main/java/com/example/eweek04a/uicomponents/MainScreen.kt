package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        //mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }

    Column (modifier = Modifier.fillMaxSize()) {
        TodoListTitle()
        Column(modifier = Modifier.weight(1f)) {
            TodoList(todoList)
        }
        Column {
            TodoItemInput(todoList)
        }
    }
}


@Preview
@Composable// ShowPendingOnly 이고 TodoState.Completed만 막으면 됨
private fun MainScreenPreview() { //TodoState.Completed만 막으면 됨
    MainScreen()
}