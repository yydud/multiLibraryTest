package com.sample.mathLibrary

import java.security.SecureRandom

public object MyMath {
    // 랜덤값 생성함
    public fun getRandom(length: Int = 100): Int? {
        try {
            val random: SecureRandom = SecureRandom()
            return random.nextInt(length)
        }
        catch (e: Exception){

        }

        return null
    }
}