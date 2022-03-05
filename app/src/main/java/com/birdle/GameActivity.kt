package com.birdle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private var word: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        word = findViewById(R.id.wordText)

        val birdName = generateBirdle(birdNames)

        val guess = findViewById<TextView>(R.id.wordText)

        //Define and attach click listener
        guess.setOnClickListener { enterGuess(birdName) }
    }

    private fun enterGuess(birdName: String) {
        word!!.text = String.format(birdName)
    }
}
