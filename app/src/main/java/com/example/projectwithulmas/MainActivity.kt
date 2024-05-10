package com.example.projectwithulmas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projectwithulmas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.stebButton.addOnChangeListener { slider, fl, b ->
            binding.textView.text = fl.toInt().toString()
            Log.d("logging", "Hello")
        }
    }
}