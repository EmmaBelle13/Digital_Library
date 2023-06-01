package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.digitallibrary.databinding.FragmentMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


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

        binding.addBooksButton.setOnClickListener{
            viewModel.createNewBook()
            val num = viewModel.books.size - 1
            val action = MainFragmentDirections.actionMainFragmentToBookInfoFragment(num)
               rootView.findNavController().navigate(action)
        }
        binding.infoButton.setOnClickListener(){
            binding.infoButton.setBackgroundColor(ContextCompat.getColor(binding.infoButton.context, R.color.gold))
        }
        var books = viewModel.books

        val myAdapter = BookAdapter(books)
        binding.recyclerView.adapter = myAdapter

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}