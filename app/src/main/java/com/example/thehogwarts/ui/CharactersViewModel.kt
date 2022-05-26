package com.example.thehogwarts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thehogwarts.network.Characters
import com.example.thehogwarts.network.CharactersApi
import kotlinx.coroutines.launch

//import androidx.lifecycle.viewModelScope

enum class CharactersApiStatus {LOADING, ERROR, DONE}

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<Characters>()
    val chararacters: LiveData<Characters> = _characters

    private val _char = MutableLiveData<List<Characters>>()
    val char: LiveData<List<Characters>> = _char

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
//            _status.value = CharactersApiStatus.LOADING
            try {
                _char.value = CharactersApi.retrofitService.getCharacters()
//                _status.value = CharactersApiStatus.DONE
            } catch (e: Exception) {
//                _char.value = ListOf()
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun onCharacterClicked(characters: Characters) {
        _characters.value = characters
    }
}