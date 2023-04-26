package com.example.digitallibrary

import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.databinding.SingleBookLayoutBinding

class BookViewHolder(val binding: SingleBookLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentBook: Book

        fun bindBook(book: Book){
            currentBook = book
            binding.titleText.text = currentBook.title
           // binding.titleText.background = currentBook.color
        }
}