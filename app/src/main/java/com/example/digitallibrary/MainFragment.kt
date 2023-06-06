package com.example.digitallibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.digitallibrary.R.string
import com.example.digitallibrary.databinding.FragmentMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookViewModel by activityViewModels()

    lateinit var dbRef: DatabaseReference
    // private var recycler: RecyclerView = binding.recyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference

        binding.addBooksButton.setOnClickListener {
            viewModel.createNewBook()
            val num = viewModel.books.size - 1
            val action = MainFragmentDirections.actionMainFragmentToBookInfoFragment(num)
            rootView.findNavController().navigate(action)
        }


        binding.infoButton.setOnClickListener {
            if (viewModel.books.size < 2) {
                Snackbar.make(
                    binding.infoButton,
                    R.string.empty_snackbar,
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            } else {
                var setMessageAnswer =
                    "You have read ${viewModel.books.size - 1} books. Great Job! One of your favorites was ${viewModel.books[viewModel.findFav()].title} by ${viewModel.books[viewModel.findFav()].author}"

                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(string.dialog)
                    .setMessage(setMessageAnswer)
                    .setPositiveButton(string.dialog_yes) { dialog, which ->
                        Toast.makeText(
                            requireContext().applicationContext,
                            R.string.positive_toast,
                            Toast.LENGTH_SHORT
                        ).show()


                    }
                    .setNegativeButton(string.dialog_no) { dialog, which ->
                        Toast.makeText(
                            requireContext().applicationContext,
                            R.string.sorry_toast,
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    .show()
            }
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