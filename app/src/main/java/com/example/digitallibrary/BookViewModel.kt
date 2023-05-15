package com.example.digitallibrary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel: ViewModel() {
    private var _title = MutableLiveData<String>("Title")
    val title: LiveData<String>
        get() = _title

    private var _author = MutableLiveData<String>("Unknown")
    val author: LiveData<String>
        get() = _author

    private var _color = MutableLiveData<String>("R.color.red")
    val color: LiveData<String>
        get() = _color

    private var _bookHeight = MutableLiveData(220)
    val bookHeight: LiveData<Int>
        get() = _bookHeight

    private var _summary = MutableLiveData<String>(" ")
    val summary: LiveData<String>
        get() = _summary

    private var _genre = MutableLiveData<String>("")
    val genre: LiveData<String>
        get() = _genre

    private var _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    //this is not what this should be I just want to get rid of the red so I can run the code
    private var _currentBook = MutableLiveData(0)
    val currentBook: LiveData<Int>
        get() = _currentBook

    fun setGenre( inputGenre: String){
        _genre.value = inputGenre

    }

    fun setScore( num: Int){
        _score.value = num
    }

//    fun setColor(color: String){
//        _score.value = color
//    }




         //   var title: String, var author: String, var color: String, var bookHeight: Int, var summary: String
}