package com.example.digitallibrary

import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.core.content.ContextCompat
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
    lateinit var myMediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCustomBinding.inflate(inflater, container, false)
        val rootView = binding.root
        setUpSpinner()
      setUpSeekBar()

        dbRef = Firebase.database.reference

        binding.setBookInfo.setOnClickListener(){
            if(!binding.editAuthor.getText().isEmpty()){
                viewModel.setTitle(binding.editAuthor.getText().toString())
            }
            if(!binding.editTitle.getText().isEmpty()){
                viewModel.setAuthor(binding.editTitle.getText().toString())
            }
            if(!binding.editSummary.getText().isEmpty()){
                viewModel.setSummary(binding.editSummary.getText().toString())
            }
            //saveBookData()


            //Should be what sends it to the firebase db but I have not actually set up information to store yet
        myMediaPlayer = MediaPlayer.create(context, R.raw.pageflip)
            myMediaPlayer.start()

            rootView.findNavController().navigateUp()
        }
        binding.editAuthor.hint = viewModel.title.value
        binding.editTitle.hint = viewModel.author.value
        binding.editSummary.hint = viewModel.summary.value


        // For each check box the furthest option to the right should automatically fill in all options up until that point
        //does not uncheck buttons when you click to the left yet
        binding.scoreOne.setOnClickListener(){
            if (binding.scoreOne.isChecked){
                viewModel.setScore(1)
                binding.scoreTwo.isChecked = false
                binding.scoreThree.isChecked = false
                   binding.scoreFour.isChecked = false
                 binding.scoreFive.isChecked = false
            }
        }
        binding.scoreTwo.setOnClickListener(){
            if (binding.scoreTwo.isChecked){
                viewModel.setScore(2)
                binding.scoreOne.isChecked = true
                binding.scoreThree.isChecked = false
                   binding.scoreFour.isChecked = false
                 binding.scoreFive.isChecked = false
            }
        }
         binding.scoreThree.setOnClickListener(){
            if (binding.scoreThree.isChecked){
                viewModel.setScore(3)
                binding.scoreOne.isChecked = true
                binding.scoreTwo.isChecked = true
                 binding.scoreFour.isChecked = false
                 binding.scoreFive.isChecked = false
            }
        }
         binding.scoreFour.setOnClickListener(){
            if (binding.scoreFour.isChecked){
                viewModel.setScore(4)
                binding.scoreOne.isChecked = true
                binding.scoreTwo.isChecked = true
                binding.scoreThree.isChecked = true
                binding.scoreFive.isChecked = false
            }
        }
        binding.scoreFive.setOnClickListener(){
            if (binding.scoreFive.isChecked){
                viewModel.setScore(5)
                binding.scoreOne.isChecked = true
                binding.scoreTwo.isChecked = true
                binding.scoreThree.isChecked = true
                binding.scoreFour.isChecked = true
            }
        }
        viewModel.color.observe(viewLifecycleOwner){
            currentColor->
            binding.colorPickerText.setTextColor(ContextCompat.getColor(binding.colorPickerText.context,currentColor))
        }

        //When a button color is chosen it either needs to glow or set the background to be that
        binding.colorButtonBlue.setOnClickListener(){
            viewModel.setBookColor(R.color.blue)
        }
        binding.colorButtonBrown.setOnClickListener(){
            viewModel.setBookColor(R.color.brown)
        }
        binding.colorButtonDarkGreen.setOnClickListener(){
            viewModel.setBookColor(R.color.dark_green)
        }

        binding.colorButtonPink.setOnClickListener(){
            viewModel.setBookColor(R.color.pink)
        }

        binding.colorButtonPurple.setOnClickListener(){
            viewModel.setBookColor(R.color.purple_gray)
        }

        binding.colorButtonRed.setOnClickListener(){
            viewModel.setBookColor(R.color.red)
        }












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
        binding.spinner.setSelection(genreArrayAdapter.getPosition(viewModel.genre.value.toString()))
        spinner.adapter = genreArrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                GuestArrayAdapter: AdapterView<*>,
                childView: View?,
                position: Int,
                itemId: Long
            ) {
                genre = genreArrayAdapter.getItem(position).toString()
            viewModel.setGenre(genre)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

    }
    fun setUpSeekBar() {

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                newProgressValue: Int,
                fromUser: Boolean
            ) {
                viewModel.setBookHeight(newProgressValue)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}

        })
    }
//    fun saveBookData(){
//        val bookId = dbRef.push().key!!
//
//        var currentBook: Book = viewModel.books[viewModel.currentBook.value!!]
//        dbRef.child("title").push().setValue(viewModel.title)
//
//    }
}