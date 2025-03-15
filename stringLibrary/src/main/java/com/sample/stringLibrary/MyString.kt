package com.sample.stringLibrary

import java.security.SecureRandom

public object MyString {
    // 랜덤 문자열 생성함
    public fun getRandom(length: Int = 100): String? {
        try {
            val characters = (('a'..'z') + ('A'..'Z')).joinToString("") // a-z와 A-Z를 포함한 문자 집합

            val random: SecureRandom = SecureRandom()
            val randomString = StringBuilder(length)

            for (i in 0 until length) {
                val randomIndex = random.nextInt(characters.length)
                randomString.append(characters[randomIndex])
            }

            return randomString.toString()
        }
        catch (e: Exception){

        }

        return null
    }
}