package com.example.digitallibrary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel: ViewModel() {

    private var _books = listOf<Book>(Book("The Great Gatsby","Fitzgerald", R.color.gold,230, "The story of Gatsby", "Fantasy", 0),
        Book("The Ok Gatsby","Fitz", R.color.pink,200, "The story of another Gatsby","Fantasy", 1),
         Book("Shadow and Bone","Fitz", R.color.brown,200, "The story of another Gatsby","Fantasy", 2),
         Book("How to Kill a Mockingbird","Fitz", R.color.blue,200, "The story of another Gatsby","Fantasy", 3),
        Book("The Great Gatsby","Fitzgerald", R.color.red,230, "The story of Gatsby","Fantasy", 4),
        Book("The Ok Gatsby","Fitz", R.color.gold,200, "The story of another Gatsby", "Fantasy", 5))
    val books: List<Book>
    //this call is necessary so that the recycler view can still be attached to the adapter in main fragment//
        get() = _books

    private var _title = MutableLiveData<String>("Title")
    val title: LiveData<String>
        get() = _title

    private var _author = MutableLiveData<String>("Unknown")
    val author: LiveData<String>
        get() = _author
//the probelm lies here//
    private var _color = MutableLiveData<Int>()
    val color: LiveData<Int>
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

    private var _num = MutableLiveData(0)
    val num: LiveData<Int>
    get() = _num

    fun setGenre( inputGenre: String){
       books[currentBook.value ?: 0].genre = inputGenre
    }

    fun setScore( num: Int){
        _score.value = num
    }

    fun setSummary(summaryDraft: String){
        _summary.value = summaryDraft
    }

    fun setBookHeight(){

    }
    fun setBookColor(bookColor: Int){
       books[currentBook.value ?: 0].color = bookColor
    }

    fun setCurrentBook(bookNum: Int){
        _currentBook.value = bookNum
    }
}