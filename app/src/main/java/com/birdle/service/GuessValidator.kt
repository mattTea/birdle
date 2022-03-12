package com.birdle.service

import com.birdle.birdNames

fun validateGuess(guess: String): Boolean =
    birdNames
        .map { it.lowercase() }
        .contains(guess.lowercase())