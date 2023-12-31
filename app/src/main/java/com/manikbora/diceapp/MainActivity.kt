package com.manikbora.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manikbora.diceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var diceNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollDiceBtn.setOnClickListener {
            diceNumber = generateRandomNumber()
            binding.diceValueTv.text = diceNumber.toString()
            setDiceImage(diceNumber)
        }

    }

    private fun generateRandomNumber(): Int {
        return (1..6).random()
    }

    private fun setDiceImage(diceNum: Int) {
        var drawableResource = when(diceNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceIv.setImageResource(drawableResource)
    }
}