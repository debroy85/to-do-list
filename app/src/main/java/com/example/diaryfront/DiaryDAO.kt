package com.example.diaryfront

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DiaryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(diary: Diary)

    @Update
    fun update(diary: Diary)

    @Delete
     fun  delete(diary: Diary)

    @Query("Select*from Diary_entries order by id ASC")
    fun getEntries(): LiveData<List<Diary>>


}