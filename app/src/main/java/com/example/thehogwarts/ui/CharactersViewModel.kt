package com.example.thehogwarts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thehogwarts.network.Characters
import com.example.thehogwarts.network.CharactersApi
import kotlinx.coroutines.launch

enum class CharactersApiStatus {LOADING, ERROR, DONE}

class CharactersViewModel : ViewModel() {

    private val _character = MutableLiveData<Characters>()
    val character: LiveData<Characters> = _character

    private val _characters = MutableLiveData<List<Characters>>()
    val characters: LiveData<List<Characters>> = _characters

    private val _status = MutableLiveData<CharactersApiStatus>()
    val status: LiveData<CharactersApiStatus> = _status

    init {
        getCharacterList()
    }

    fun getCharacterList() {
        viewModelScope.launch {
            _status.value = CharactersApiStatus.LOADING
            try {
                _characters.value = CharactersApi.retrofitService.getCharacters()
                _status.value = CharactersApiStatus.DONE
            } catch (e: Exception) {
                _characters.value = listOf()
                _status.value = CharactersApiStatus.ERROR
            }
        }
    }

    fun onCharacterClicked(characters: Characters) {
        _character.value = characters
    }
}