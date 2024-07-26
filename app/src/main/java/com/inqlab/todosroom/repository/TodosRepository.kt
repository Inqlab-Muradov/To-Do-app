package com.inqlab.todosroom.repository

import com.inqlab.todosroom.room.Todos
import com.inqlab.todosroom.room.TodosDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TodosRepository @Inject constructor(
    val todosDAO: TodosDAO
) {

    fun addTodo(todos:Todos){
        todosDAO.addTodos(todos)
    }

    fun  getAllTodos() = todosDAO.getAllTodos().flowOn(Dispatchers.IO)

    fun deleteTodo(id : Int){
        todosDAO.deleteTodos(id)
    }

    fun updateTodos(isfav:Boolean,id:Int){
        todosDAO.updateTodos(isfav,id)
    }
    fun getCompletedTodos() = todosDAO.getAllTodosWithFav().flowOn(Dispatchers.IO)

    fun getDetailTodo(id:Int) = todosDAO.getDetailTodos(id).flowOn(Dispatchers.IO)
}