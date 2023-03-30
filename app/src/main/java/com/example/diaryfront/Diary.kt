package com.example.diaryfront

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Diary_entries")
class Diary(@ColumnInfo(name = "title")val DiaryTitle: String,@ColumnInfo(name ="Description")val Diary_des:String,@ColumnInfo(name = "time")val time_stamp: String) {
    @PrimaryKey(autoGenerate = true)
    var id =0


}