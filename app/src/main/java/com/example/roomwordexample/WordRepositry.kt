package com.example.roomwordexample

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class WordRepositry(private val wordDao: WordDao){
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

}
