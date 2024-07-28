package com.inqlab.todosroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inqlab.todosroom.repository.TodosRepository
import com.inqlab.todosroom.room.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    val repository: TodosRepository
) : ViewModel() {

    fun addTodo(todos: Todos) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todos)
        }

    }
}