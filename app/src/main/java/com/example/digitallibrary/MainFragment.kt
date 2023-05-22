package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitallibrary.databinding.FragmentMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.reflect.Array.get


class MainFragment : Fragment() {
    private var _binding:  FragmentMainBinding? = null
    private val  binding get() =  _binding!!
     private val viewModel: BookViewModel by activityViewModels()

    lateinit var dbRef : DatabaseReference
   // private var recycler: RecyclerView = binding.recyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference
       // recycler.layoutManager = GridLayoutManager(requireContext(), 3)

        binding.addBooksButton.setOnClickListener{
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_bookInfoFragment)
        }
        binding.infoButton.setOnClickListener(){
            binding.infoButton.setBackgroundColor(R.id.color_button_red)
        }
        val books = listOf<Book>(Book("The Great Gatsby","Fitzgerald", "@color/light_green",230, "The story of Gatsby"),
        Book("The Ok Gatsby","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("Shadow and Bone","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("How to Kill a Mockingbird","Fitz", "@color/green",200, "The story of another Gatsby"),
        Book("The Great Gatsby","Fitzgerald", "@color/light_green",230, "The story of Gatsby"),
        Book("The Ok Gatsby","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("Shadow and Bone","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("How to Kill a Mockingbird","Fitz", "@color/green",200, "The story of another Gatsby"),
        Book("The Great Gatsby","Fitzgerald", "@color/light_green",230, "The story of Gatsby"),
        Book("The Ok Gatsby","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("Shadow and Bone","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("How to Kill a Mockingbird","Fitz", "@color/green",200, "The story of another Gatsby"),
        Book("The Great Gatsby","Fitzgerald", "@color/light_green",230, "The story of Gatsby"),
        Book("The Ok Gatsby","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("Shadow and Bone","Fitz", "@color/green",200, "The story of another Gatsby"),
         Book("How to Kill a Mockingbird","Fitz", "@color/green",200, "The story of another Gatsby"))

        val myAdapter = BookAdapter(books)
        binding.recyclerView.adapter = myAdapter

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}