package com.example.projectwithulmas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projectwithulmas.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        var randomNumber = Random.nextInt(-10,11)
        var userNumber : Int = 0
        setContentView(binding.root)
        binding.stebButton.addOnChangeListener { slider, fl, b ->
            userNumber = fl.toInt()
        }
        binding.checkButton.setOnClickListener{
            if(userNumber == randomNumber){
               binding.textResult.text = "Верно"
            }
            else{
                if(userNumber < randomNumber){
                    binding.textResult.text = "Больше"
                }
                else{
                    binding.textResult.text = "Меньше"
                }
            }
        }
        binding.restartButton.setOnClickListener{
            randomNumber = Random.nextInt(-10,11)
        }
    }
}