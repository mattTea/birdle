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
import com.birdle.service.validateGuess

class GameActivity : AppCompatActivity() {
    private var word: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        word = findViewById(R.id.resultText)

        val birdName = generateBirdle(birdNames)
        val attemptViews = listOf<EditText>(
            findViewById(R.id.guessText1),
            findViewById(R.id.guessText2),
            findViewById(R.id.guessText3)
        )

        val editTextPositionMap = attemptViews.mapIndexed { index, editText ->  Pair(editText, index) }.toMap()

        val guessButton = findViewById<Button>(R.id.guessButton)
        guessButton.setOnClickListener {
            enterGuess(birdName, attemptViews, editTextPositionMap[currentFocus]!!)
        }

        findViewById<EditText>(R.id.guessText1).requestFocus()
    }

    private fun enterGuess(birdName: String, attemptViews: List<EditText>, attempt: Int) {
        val guessWord = attemptViews[attempt].text.toString()

        println("GUESSWORD -> $guessWord")
        println("BIRDNAME -> $birdName")

        if (!validateGuess(guessWord)) {
            word!!.text = String.format("Bird not in list")
            return
        }

        val letterResults = guessWord
            .mapIndexed { index, letter -> checkLetter(letter, index, birdName) }
            .map {
                when (it) {
                    CORRECT -> 'G'
                    PART_CORRECT -> 'A'
                    INCORRECT -> 'R'
                }
            }
            .joinToString(" | ")

        word!!.text = String.format(letterResults)

        if (attempt < attemptViews.indices.last) attemptViews[attempt+1].requestFocus()
        else word!!.text = String.format("Bad luck!")
        println("current focus after guess $attempt: $currentFocus")
    }
}
