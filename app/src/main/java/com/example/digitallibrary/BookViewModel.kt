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

    private var _color = MutableLiveData<String>("@color/red")
    val color: LiveData<String>
        get() = _color

    //this is not what this should be I just want to get rid of the red so I can run the code
    private var _currentBook = MutableLiveData(0)
    val currentBook: LiveData<Int>
        get() = _currentBook




         //   var title: String, var author: String, var color: String, var bookHeight: Int, var summary: String
}