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

        fun bindBook(book: Book){
            currentBook = book
            binding.titleText.text = currentBook.title
            binding.titleText.width = currentBook.bookHeight
            //All colors turn to blue for some reason
//            binding.titleText.setTextColor(R.color.black)
           //I need to be able to adjust this displayed information in some way the text works but it is the only one
        }
}



