package com.example.thehogwarts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thehogwarts.network.Characters
import com.example.thehogwarts.network.MarsApi
import kotlinx.coroutines.launch

//import androidx.lifecycle.viewModelScope

enum class CharactersApiStatus {LOADING, ERROR, DONE}

class CharactersViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getCharacters()
            _status.value = listResult
        }
        _status.value = "Set the Mars API status response here!"
    }

    fun onCharacterClicked(characters: Characters) {
        // TODO: Set the amphibian object
    }
}
//
//private fun getCharacters() {
////    viewModelScope.launch {
////    }
//}