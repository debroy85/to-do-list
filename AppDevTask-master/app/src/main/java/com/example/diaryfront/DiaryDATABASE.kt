package com.example.diaryfront

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext


@Database(entities = arrayOf(Diary::class), version = 1, exportSchema = false)
abstract class DiaryDATABASE: RoomDatabase() {
    abstract fun getDiaryDAO() : DiaryDAO

    companion object{

        @Volatile
        private var Instance: DiaryDATABASE?= null

        fun getDatabase(context: Context): DiaryDATABASE{
            return Instance?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                DiaryDATABASE::class.java,"Diary_database"
                ).build()
                Instance = instance
                instance
            }
        }
    }
}