package com.jlapp.roomexample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.jlapp.roomexample.dao.WordDao
import com.jlapp.roomexample.model.Word

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}