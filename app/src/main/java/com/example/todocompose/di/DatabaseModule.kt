package com.example.todocompose.di

import android.content.Context
import androidx.room.Room
import com.example.todocompose.data.presistance.database.TodoDatabase
import com.example.todocompose.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideDao(database: TodoDatabase) = database.todoDao()
}