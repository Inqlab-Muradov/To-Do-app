package com.inqlab.todosroom.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodosDAO {

    @Insert
    fun addTodos(todos: Todos)

    @Query("select * from todos_table")
    fun getAllTodos(): Flow<List<Todos>>

    @Query("delete from todos_table where id=:todosID")
    fun deleteTodos(todosID: Int)

    @Query("update todos_table SET IsFav=:isfav where id = :todosID")
    fun updateTodos(isfav: Boolean, todosID: Int)

    @Query("select * from todos_table where IsFav=1")
    fun getAllTodosWithFav(): Flow<List<Todos>>

    @Query("select * from todos_table where id=:todosID")
    fun getDetailTodos(todosID: Int): Flow<Todos>

}