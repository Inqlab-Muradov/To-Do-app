package com.inqlab.todosroom.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todos::class], version = 2)
abstract class TodosDatabase : RoomDatabase (){

    abstract fun getDao():TodosDAO

}