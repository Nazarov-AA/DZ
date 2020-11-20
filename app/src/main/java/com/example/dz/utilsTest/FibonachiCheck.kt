package com.example.dz.utilsTest

object FibonachiCheck {

    fun counter(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 2) return 1
        var a = 1
        var b = 1
        var x = 0
        for (i in 3..n) {
            x = a + b
            a = b
            b = x
        }
        return x
    }

}