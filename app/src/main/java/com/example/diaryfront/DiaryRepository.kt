package com.example.diaryfront

import androidx.lifecycle.LiveData

class DiaryRepository(private val diaryDAO: DiaryDAO) {

    val allEntries: LiveData<List<Diary>> = diaryDAO.getEntries()

     fun insert(diary: Diary){
        diaryDAO.insert(diary)
    }
    fun delete(diary: Diary){
        diaryDAO.delete(diary)
    }
    fun update(diary: Diary){
        diaryDAO.update(diary)
    }



}