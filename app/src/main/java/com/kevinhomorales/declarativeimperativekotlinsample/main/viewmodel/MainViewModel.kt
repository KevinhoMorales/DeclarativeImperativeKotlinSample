package com.kevinhomorales.declarativeimperativekotlinsample.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _number = MutableLiveData(0)
    val number: LiveData<Int> get() = _number

    fun incrementNumberImperative(numberString: String, completion: (String) -> Unit) {
        val number = numberString.toInt()
        val newNumber = number + 1
        completion(newNumber.toString())
    }

    fun incrementNumberDeclarative() {
        _number.value = (_number.value ?: 0) + 1
    }
}