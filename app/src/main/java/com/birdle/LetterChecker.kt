package com.birdle

import com.birdle.GuessResult.CORRECT
import com.birdle.GuessResult.INCORRECT
import com.birdle.GuessResult.PART_CORRECT

fun checkLetter(
    guessLetter: Char,
    guessPosition: Int,
    answerWord: String
): GuessResult =
    when {
        answerWord[guessPosition] == guessLetter-> CORRECT
        answerWord.contains(guessLetter) -> PART_CORRECT
        else -> INCORRECT
    }

enum class GuessResult { CORRECT, PART_CORRECT, INCORRECT }