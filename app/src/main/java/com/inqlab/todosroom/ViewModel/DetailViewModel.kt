package com.inqlab.todosroom.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inqlab.todosroom.repository.TodosRepository
import com.inqlab.todosroom.room.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    val repository: TodosRepository
) : ViewModel() {
    val detailTodoList = MutableLiveData<Todos>()

    fun getDetailTodo(id:Int){
        viewModelScope.launch (Dispatchers.IO){
            val list = repository.getDetailTodo(id)
            withContext(Dispatchers.Main){
                detailTodoList.value = list
            }
        }
    }
}