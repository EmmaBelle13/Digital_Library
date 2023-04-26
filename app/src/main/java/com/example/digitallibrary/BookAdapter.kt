package com.example.digitallibrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.databinding.SingleBookLayoutBinding

class BookAdapter(val bookList: List<Book>) : RecyclerView.Adapter<BookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = SingleBookLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = bookList[position]
        holder.bindBook(currentBook)
    }

    override fun getItemCount(): Int {
       return bookList.size
    }
}