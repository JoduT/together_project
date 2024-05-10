package com.example.projectwithulmas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.projectwithulmas.SQL.App
import com.example.projectwithulmas.SQL.NewHistory
import com.example.projectwithulmas.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val dao = (application as App).db.getDao()
        val allHistory = dao.getAll().stateIn(
            scope = lifecycleScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

        var randomNumber = Random.nextInt(-10,11)
        var userNumber : Int = 0
        setContentView(binding.root)
        binding.stebButton.addOnChangeListener { slider, fl, b ->
            userNumber = fl.toInt()
        }
        binding.checkButton.setOnClickListener{
            var text: String
            if(userNumber == randomNumber){
               binding.textResult.text = "Верно"
                text = "Верно"
            }
            else{
                if(userNumber < randomNumber){
                    binding.textResult.text = "Больше"
                    text = "Больше"
                }
                else{
                    binding.textResult.text = "Меньше"
                    text = "Меньше"
                }
            }
            lifecycleScope.launch {
                dao.insert(NewHistory(number = userNumber, text = text))
            }
        }
        binding.restartButton.setOnClickListener{
            randomNumber = Random.nextInt(-10,11)
        }

        lifecycleScope.launch {
            allHistory.collectLatest {
                var text: String
                binding.textHistory.text = null
                it.forEach {
                    text = "${it.id}: (${it.number}) - ${it.text}\n"
                    binding.textHistory.append(text)
                }
            }
        }
    }
}