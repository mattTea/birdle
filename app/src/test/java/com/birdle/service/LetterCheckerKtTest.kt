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

    /*
    Other rules to be tested...
    - Functional test the activity steps... somehow

    - Check word is in list of words DONE
    - Behaviour around multiple use of a single letter
      - If you’ve input two of the same letter and one of them is greyed out, this indicates that only one of that letter appears in the final word
      - If you repeat a letter more than it appears, then the excess will be highlighted in grey
      - The word “ABBEY” would show green where 'B' is corrected guessed, but if your guess contains a second B in the wring place this would be yellow

      - Both B's in wrong place - both yellow
      - Both B's in right place = both green
      - One in right, one wrong, one green, one yellow
      - A third one in wrong place would be grey

    - Where a single letter is in secret word, but you guess it twice
      - If neither are correct - first one is yellow, other one is grey
      - If one is correct - that would be green, other would be grey
     */
}