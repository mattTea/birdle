package com.birdle

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.birdle.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    private var message: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        message = findViewById(R.id.welcomeText)
        val birdle = findViewById<ImageView>(R.id.birdleImage)

        //Define and attach click listener
        birdle.setOnClickListener { tapBirdle() }
    }

    private fun tapBirdle() {
        val gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }
}