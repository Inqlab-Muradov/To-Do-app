package com.inqlab.todosroom.di

import android.content.Context
import androidx.room.Room
import com.inqlab.todosroom.room.TodosDAO
import com.inqlab.todosroom.room.TodosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context):TodosDatabase{
        return Room.databaseBuilder(context,TodosDatabase::class.java,"TodosDb").fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(todosDatabase: TodosDatabase) : TodosDAO{
        return todosDatabase.getDao()
    }
}