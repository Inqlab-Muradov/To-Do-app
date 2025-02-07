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
class CompletedViewModel @Inject constructor(
    val repository: TodosRepository
) : ViewModel() {

    val completedList = MutableLiveData<List<Todos>>()

    fun getTodosWithFav() {
        viewModelScope.launch {
            repository.getCompletedTodos().collectLatest {
                completedList.value = it
            }
        }
    }

    fun updateCompletedTodo(isFav: Boolean, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodos(isFav, id)
            getTodosWithFav()
        }
    }
}