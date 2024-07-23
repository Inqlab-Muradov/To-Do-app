package com.inqlab.todosroom.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos_table")
 data class Todos (
    @PrimaryKey(autoGenerate = true)
     val id:Int = 0,
    @ColumnInfo("tasks")
     val task : String,
    @ColumnInfo("descriptions")
     val description:String,
    @ColumnInfo("dates")
     val date:String,
    @ColumnInfo("IsFav")
     val isFav:Boolean
 )
