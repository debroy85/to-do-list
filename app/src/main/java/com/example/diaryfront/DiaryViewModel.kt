package com.example.diaryfront

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiaryViewModel(application: Application): AndroidViewModel(application) {
     val allEntries: LiveData<List<Diary>>
     val repository: DiaryRepository

    init{
        val dao = DiaryDATABASE.getDatabase(application).getDiaryDAO()
        repository = DiaryRepository(dao)
        allEntries = repository.allEntries
    }

    fun deleteEntry(diary: Diary) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(diary)
    }

    fun addEntry(diary: Diary)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(diary)

    }
    fun updateEntry(diary: Diary)= viewModelScope.launch(Dispatchers.IO){
        repository.update(diary)
    }
}