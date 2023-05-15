package com.example.digitallibrary

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.databinding.SingleBookLayoutBinding

class BookViewHolder(val binding: SingleBookLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val rootView = binding.root
    init {
        binding.root.setOnClickListener{view->
               rootView.findNavController().navigate(R.id.action_mainFragment_to_bookInfoFragment)


        }
    }

        private lateinit var currentBook: Book

        fun bindBook(book: Book){
            currentBook = book
            binding.titleText.text = currentBook.title
           // binding.titleText.background = currentBook.color
        }
}