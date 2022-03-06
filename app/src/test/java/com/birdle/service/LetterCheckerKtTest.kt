package com.birdle.service

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.birdle.service.GuessResult.CORRECT
import com.birdle.service.GuessResult.INCORRECT
import com.birdle.service.GuessResult.PART_CORRECT
import org.junit.jupiter.api.Test

internal class LetterCheckerKtTest {
    @Test
    fun `should return correct for correct letter`() {
        val answerWord = "a"
        val guessPosition = 0
        val correctGuessLetter = 'a'

        val result = checkLetter(
            guessLetter = correctGuessLetter,
            guessPosition = guessPosition,
            answerWord = answerWord
        )

        assertThat(result).isEqualTo(CORRECT)
    }

    @Test
    fun `should return incorrect for incorrect letter`() {
        val answerWord = "a"
        val guessPosition = 0
        val incorrectGuessLetter = 'b'

        val result = checkLetter(
            guessLetter = incorrectGuessLetter,
            guessPosition = guessPosition,
            answerWord = answerWord
        )

        assertThat(result).isEqualTo(INCORRECT)
    }

    @Test
    fun `should return part_correct for correct letter in wrong position`() {
        val incorrectGuessLetter = 'b'
        val guessPosition = 0
        val answerWord = "ab"

        val result = checkLetter(
            guessLetter = incorrectGuessLetter,
            guessPosition = guessPosition,
            answerWord = answerWord
        )

        assertThat(result).isEqualTo(PART_CORRECT)
    }
}