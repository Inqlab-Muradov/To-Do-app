package com.inqlab.todosroom.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inqlab.todosroom.repository.TodosRepository
import com.inqlab.todosroom.room.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: TodosRepository
) : ViewModel() {

    val todosList = MutableLiveData<List<Todos>>()

    fun getAllTodos() {
        viewModelScope.launch {
            repository.getAllTodos().collectLatest {
                todosList.value = it
            }
        }

    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(id)
            getAllTodos()
        }
    }

    fun updateTodo(isfav: Boolean, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodos(isfav, id)
        }
    }

}