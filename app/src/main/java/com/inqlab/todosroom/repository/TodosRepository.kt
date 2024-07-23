package com.inqlab.todosroom.repository

import com.inqlab.todosroom.room.Todos
import com.inqlab.todosroom.room.TodosDAO
import javax.inject.Inject

class TodosRepository @Inject constructor(
    val todosDAO: TodosDAO
) {

    fun addTodo(todos:Todos){
        todosDAO.addTodos(todos)
    }

    suspend fun  getAllTodos() = todosDAO.getAllTodos()

    fun deleteTodo(id : Int){
        todosDAO.deleteTodos(id)
    }

    fun updateTodos(isfav:Boolean,id:Int){
        todosDAO.updateTodos(isfav,id)
    }

    suspend fun getCompletedTodos() = todosDAO.getAllTodosWithFav()

    suspend fun getDetailTodo(id:Int) = todosDAO.getDetailTodos(id)
}