package com.example.dz

import com.example.dz.utilsTest.FibonachiCheck
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonachiCheckTest {

    @Test
    fun checkNumberFibonacci_returns_true() {
        var result = true
        val map = mapOf(
            0 to 0,
            1 to 1,
            2 to 1,
            3 to 2,
            4 to 3,
            5 to 5,
            6 to 8,
            7 to 13,
            8 to 21,
            9 to 34,
            10 to 55
        )
        for ((key, value) in map) {
            result = (value == FibonachiCheck.counter(key))
            assertThat(result).isTrue()
        }
    }
}