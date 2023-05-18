package com.example.digitallibrary

import android.annotation.SuppressLint
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.R.*
import com.example.digitallibrary.databinding.SingleBookLayoutBinding

class BookViewHolder(val binding: SingleBookLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val rootView = binding.root
    init {
        binding.root.setOnClickListener{view->
               rootView.findNavController().navigate(id.action_mainFragment_to_bookInfoFragment)


        }
    }

        private lateinit var currentBook: Book

        @SuppressLint("ResourceAsColor")
        fun bindBook(book: Book){
            currentBook = book
            binding.titleText.text = currentBook.title
            var color = currentBook.color
            binding.titleText.setBackgroundColor(R.color.blue)
        }
}


