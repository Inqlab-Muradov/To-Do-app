package com.inqlab.todosroom.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inqlab.todosroom.repository.TodosRepository
import com.inqlab.todosroom.room.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    val repository: TodosRepository
) : ViewModel() {
    val detailTodoList = MutableLiveData<Todos>()

    fun getDetailTodo(id: Int) {
        viewModelScope.launch {
            repository.getDetailTodo(id).collectLatest {
                detailTodoList.value = it
            }
        }
    }
}