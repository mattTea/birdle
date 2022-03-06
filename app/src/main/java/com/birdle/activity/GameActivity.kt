package com.birdle.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.birdle.R
import com.birdle.birdNames
import com.birdle.service.generateBirdle
import com.birdle.service.GuessResult.CORRECT
import com.birdle.service.GuessResult.INCORRECT
import com.birdle.service.GuessResult.PART_CORRECT
import com.birdle.service.checkLetter

class GameActivity : AppCompatActivity() {
    private var word: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        word = findViewById(R.id.wordText)

        val birdName = generateBirdle(birdNames)

        val guessButton = findViewById<Button>(R.id.guessButton)
        guessButton.setOnClickListener { enterGuess(birdName) }
    }

    private fun enterGuess(birdName: String) {
        val guessLetter1 = findViewById<EditText>(R.id.guessText1).text.toString()
        val guessLetter2 = findViewById<EditText>(R.id.guessText2).text.toString()
        val guessLetter3 = findViewById<EditText>(R.id.guessText3).text.toString()
        val guessLetter4 = findViewById<EditText>(R.id.guessText4).text.toString()
        val guessLetter5 = findViewById<EditText>(R.id.guessText5).text.toString()

        val guessWord = listOf(guessLetter1, guessLetter2, guessLetter3, guessLetter4, guessLetter5)
            .joinToString("")

        println("GUESSWORD -> $guessWord")
        println("BIRDNAME -> $birdName")

        val letterResults = guessWord
            .mapIndexed { index, letter -> checkLetter(letter, index, birdName) }
            .map {
                when (it) {
                    CORRECT -> 'G'
                    PART_CORRECT -> 'A'
                    INCORRECT -> 'R'
                }
            }
            .joinToString()

        word!!.text = String.format(letterResults)
    }
}
