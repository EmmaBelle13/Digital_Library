package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitallibrary.databinding.FragmentCustomBinding


class CustomFragment : Fragment() {
    private var _binding: FragmentCustomBinding? = null
       private val  binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCustomBinding.inflate(inflater, container, false)
        val rootView = binding.root


        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}