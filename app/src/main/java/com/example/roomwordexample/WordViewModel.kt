package com.example.roomwordexample
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomwordexample.Word
import com.example.roomwordexample.WordRepositry
import com.example.roomwordexample.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {
    private val repositry: WordRepositry
    val allwords: LiveData<List<Word>>
    init{
        val wordsDao = WordRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        repositry = WordRepositry(wordsDao)
        allwords = repositry.allWords
    }
    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO){
        repositry.insert(word)
    }

}
