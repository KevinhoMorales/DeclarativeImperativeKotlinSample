package com.kevinhomorales.declarativeimperativekotlinsample.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kevinhomorales.declarativeimperativekotlinsample.databinding.ActivityMainBinding
import com.kevinhomorales.declarativeimperativekotlinsample.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        viewModel = MainViewModel()
//        setUpImperative()
        observerNumber()
        setUpDeclarative()
    }

    private fun setUpImperative() {
        binding.buttonId.setOnClickListener {
            val number = binding.numberTextId.text.toString()
            viewModel.incrementNumberImperative(number) { newNumber ->
                binding.numberTextId.text = newNumber
            }
        }
    }

    private fun observerNumber() {
        viewModel.number.observe(this , Observer { nuevoNombre ->
            binding.numberTextId.text = nuevoNombre.toString()
        })
    }

    private fun setUpDeclarative() {
        binding.buttonId.setOnClickListener {
            viewModel.incrementNumberDeclarative()
        }
    }
}