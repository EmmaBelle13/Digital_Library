package com.example.digitallibrary

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.digitallibrary.databinding.FragmentBookInfoBinding


class BookInfoFragment : Fragment() {
    private var _binding: FragmentBookInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookViewModel by activityViewModels()
    lateinit var myMediaPlayer: MediaPlayer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookInfoBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = BookInfoFragmentArgs.fromBundle(requireArguments())
        viewModel.setCurrentBook(args.bookNum)



        binding.bookBackground.setBackgroundColor(ContextCompat.getColor(binding.bookBackground.context, viewModel.color.value ?: 0))
        binding.titleTextInfo.text = viewModel.title.value
        binding.bookSummary.text = viewModel.summary.value
        binding.authorsName.text = viewModel.author.value
        binding.genre.text = viewModel.genre.value
        binding.score.text = viewModel.score.value.toString()




        binding.editButton.setOnClickListener(){
            myMediaPlayer = MediaPlayer.create(context, R.raw.pageflip)
            myMediaPlayer.start()
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