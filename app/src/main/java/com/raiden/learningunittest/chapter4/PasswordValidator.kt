package com.raiden.learningunittest.chapter4

class PasswordValidator {
    companion object {
        private const val MIN_PASSWORD_LENGTH = 8
    }

    fun validateDigit(password: String): Boolean {
        val regex = ".*\\d+.*".toRegex()
        return password.matches(regex)
    }

    fun validateLength(password: String) = password.length >= MIN_PASSWORD_LENGTH

    fun validateLetter(password: String): Boolean {
        val regex = ".*\\D+.*".toRegex()
        return password.matches(regex)
    }

    fun validate(password: String): Boolean {
        return validateDigit(password) && validateLetter(password) && validateLength(password)
    }
}