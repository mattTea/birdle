package com.birdle.service

import com.birdle.service.GuessResult.CORRECT
import com.birdle.service.GuessResult.INCORRECT
import com.birdle.service.GuessResult.PART_CORRECT

fun checkLetter(
    guessLetter: Char,
    guessPosition: Int,
    answerWord: String
): GuessResult =
    when {
        answerWord[guessPosition].lowercase() == guessLetter.lowercase() -> CORRECT
        answerWord.contains(guessLetter) -> PART_CORRECT
        else -> INCORRECT
    }

enum class GuessResult { CORRECT, PART_CORRECT, INCORRECT }