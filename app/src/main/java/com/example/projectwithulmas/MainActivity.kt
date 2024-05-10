package com.example.projectwithulmas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectwithulmas.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var randomNumber = Random.nextInt(-10,11)
        var userNumber : Int = 0
        var historyText : String = ""
        binding.stebButton.addOnChangeListener { slider, fl, b ->
            userNumber = fl.toInt()
        }
        binding.checkButton.setOnClickListener{
            if(userNumber == randomNumber){
               binding.resultText.text = "Верно"
                historyText += " Верно"
            }
            else{
                if(userNumber < randomNumber){
                    binding.resultText.text = "Больше"
                }
                else{
                    binding.resultText.text = "Меньше"
                }
                historyText += " Неверно"
            }
            binding.historyText.text = historyText
        }
        binding.restartButton.setOnClickListener{
            randomNumber = Random.nextInt(-10,11)
        }
    }
}