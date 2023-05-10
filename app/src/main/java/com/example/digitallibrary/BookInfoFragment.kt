package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.digitallibrary.databinding.FragmentBookInfoBinding


class BookInfoFragment : Fragment() {
    private var _binding: FragmentBookInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookInfoBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.editButton.setOnClickListener(){
            rootView.findNavController().navigate(R.id.action_bookInfoFragment_to_customFragment)
        }
        binding.backButton.setOnClickListener(){
            rootView.findNavController().navigateUp()
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}