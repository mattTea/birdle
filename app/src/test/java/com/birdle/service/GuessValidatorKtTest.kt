package com.birdle.service

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

internal class GuessValidatorKtTest {
    @Test
    fun `should return true for guess that is in birdNames list`() {
        val guess = "GOoSe"

        val result = validateGuess(guess)

        assertThat(result).isTrue()
    }

    @Test
    fun `should return false for guess that is not in birdNames list`() {
        val guess = "xutSE"

        val result = validateGuess(guess)

        assertThat(result).isFalse()
    }
}