package com.example.thehogwarts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.thehogwarts.R
import com.example.thehogwarts.databinding.FragmentCharacterListBinding

class CharactersListFragment : Fragment() {

    private val viewModel: CharactersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCharacterListBinding.inflate(inflater)

        viewModel.getCharacters()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CharactersListAdapter(CharactersListener { characters ->
            viewModel.onCharacterClicked(characters)
            findNavController()
                .navigate(R.id.action_charactersListFragment_to_charactersDetailFragment)
        })

        return binding.root
    }
}