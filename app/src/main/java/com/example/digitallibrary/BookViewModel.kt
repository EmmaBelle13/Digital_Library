package com.example.digitallibrary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel: ViewModel() {

    private var _books = mutableListOf<Book>(Book("The Great Gatsby","Fitzgerald", R.color.gold,500, "The story of Gatsby", "Fantasy", 0, 0),
        Book("The Ok Gatsby","Fitz", R.color.pink,510, "The story of another Gatsby","Fantasy", 1, 0),
         Book("Shadow and Bone","Fitz", R.color.brown,520, "The story of another Gatsby","Fantasy", 2, 0),
         Book("How to Kill a Mockingbird","Fitz", R.color.blue,530, "The story of another Gatsby","Fantasy", 3, 0),
        Book("The Great Gatsby","Fitzgerald", R.color.red,540, "The story of Gatsby","Fantasy", 4, 0),
        Book("The Ok Gatsby","Fitz", R.color.gold,550, "The story of another Gatsby", "Fantasy", 5, 0))
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
    private var _color = MutableLiveData<Int>(R.color.red)
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
        _genre.value = inputGenre
       books[currentBook.value ?: 0].genre = inputGenre
    }

    fun setScore( num: Int){
        _score.value = num
         books[currentBook.value ?: 0].score = num
    }

    fun setSummary(summaryDraft: String){
        _summary.value = summaryDraft
         books[currentBook.value ?: 0].summary = summaryDraft
    }

    fun setBookHeight(customHeight: Int){
        _bookHeight.value = customHeight
        books[currentBook.value ?: 0].bookHeight = customHeight

    }
    fun setBookColor(bookColor: Int){
       books[currentBook.value ?: 0].color = bookColor
           _color.value = bookColor
    }
    fun setTitle(title: String){
        _title.value = title
         books[currentBook.value ?: 0].title = title
    }
    fun setAuthor(author: String){
        _author.value = author
         books[currentBook.value ?: 0].author = author
    }

    fun setCurrentBook(bookNum: Int){
        _currentBook.value = bookNum
        setTitle(books[bookNum].title)
        setBookColor(books[bookNum].color)
        setSummary(books[bookNum].summary)
        setGenre(books[bookNum].genre)
        setAuthor(books[bookNum].author)

    }
    fun createNewBook(){
        val location = books.size - 1
        _books.add(Book("Title","Unknown",R.color.red, 500, "A Summary", "Fantasy", location, 0))
        setCurrentBook(location)
    }

}