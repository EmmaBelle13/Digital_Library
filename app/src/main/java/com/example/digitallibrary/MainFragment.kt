package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitallibrary.databinding.FragmentMainBinding
import java.lang.reflect.Array.get

class MainFragment : Fragment() {
    private var _binding:  FragmentMainBinding? = null
    private val  binding get() =  _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}