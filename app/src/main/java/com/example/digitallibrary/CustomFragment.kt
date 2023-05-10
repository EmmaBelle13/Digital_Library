package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.digitallibrary.databinding.FragmentCustomBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class CustomFragment : Fragment() {
    private var _binding: FragmentCustomBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookViewModel by activityViewModels()
    lateinit var genre: String
    lateinit var dbRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCustomBinding.inflate(inflater, container, false)
        val rootView = binding.root
        setUpSpinner()

        dbRef = Firebase.database.reference

        binding.setBookInfo.setOnClickListener(){
       //     var currentBook: Book = viewModel.currentBook
            //Should be what sends it to the firebase db but I have not actually set up information to store yet
       //     dbRef.child("book").push().setValue(currentBook)
            rootView.findNavController().navigate(R.id.action_customFragment_to_bookInfoFragment)
        }


//        binding.backButtonCustom.setOnClickListener{
//            rootView.findNavController()
//                .navigate(R.id.action_cus_to_customFragment)
//        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun setUpSpinner() {
        val spinner = binding.spinner
        val genreArrayAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.genre_options_array,
            android.R.layout.simple_spinner_item
        )
        genreArrayAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = genreArrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                GuestArrayAdapter: AdapterView<*>,
                childView: View?,
                position: Int,
                itemId: Long
            ) {
                genre = genreArrayAdapter.getItem(position).toString()

            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

    }
}