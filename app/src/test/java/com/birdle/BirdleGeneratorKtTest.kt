package com.birdle

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.containsExactlyInAnyOrder
import org.junit.jupiter.api.Test

internal class BirdleGeneratorKtTest {
    @Test
    fun `should select name from list of names`() {
        val names = listOf(
            "Crake",
            "Crane",
            "Finch",
            "Heron",
        )

        val result = generateBirdle(names)

        assertThat(names).contains(result)
    }

    @Test
    fun `should randomly generate all names in list`() {
        val names = listOf("heron", "crake")

        fun namesGenerator(generatedNames: List<String> = emptyList(), runNumber: Int = 0): List<String> =
            if (runNumber == 50) generatedNames
            else namesGenerator((generatedNames + generateBirdle(names)), runNumber + 1)

        assertThat(namesGenerator().toSet()).containsExactlyInAnyOrder("heron", "crake")
    }
}