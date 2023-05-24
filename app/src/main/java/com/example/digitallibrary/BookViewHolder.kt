package com.example.digitallibrary

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.R.*
import com.example.digitallibrary.databinding.SingleBookLayoutBinding
import java.security.AccessController.getContext

class BookViewHolder(val binding: SingleBookLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

      private lateinit var currentBook: Book
    val rootView = binding.root
    init {
        binding.root.setOnClickListener{view->
            val num = currentBook.bookNumber
            val action = MainFragmentDirections.actionMainFragmentToBookInfoFragment(num)
               rootView.findNavController().navigate(action)
//this book does not know what number it is you aren't supposed to set up a view model in the view holder i think I am going to let each book know what its position is because it has access to the book information just not the list

        }
    }



        fun bindBook(book: Book){
            currentBook = book
            binding.titleText.text = currentBook.title
          //  binding.titleText.setW = currentBook.bookHeight
            var color = currentBook.color
         binding.titleText.setBackgroundColor(ContextCompat.getColor(binding.titleText.context, color))
           //I need to be able to adjust this displayed information in some way the text works but it is the only one
        }
}



