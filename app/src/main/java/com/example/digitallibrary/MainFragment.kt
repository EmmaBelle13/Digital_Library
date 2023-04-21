package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.digitallibrary.databinding.FragmentMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.reflect.Array.get


class MainFragment : Fragment() {
    private var _binding:  FragmentMainBinding? = null
    private val  binding get() =  _binding!!

    lateinit var dbRef : DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference

        binding.addBooksButton.setOnClickListener{
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_customFragment)
        }


        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}