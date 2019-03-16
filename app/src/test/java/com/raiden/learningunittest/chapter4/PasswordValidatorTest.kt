package com.raiden.learningunittest.chapter4

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class PasswordValidatorTest {
    lateinit var passwordValidator: PasswordValidator
    @Before
    fun setUp() {
        passwordValidator = PasswordValidator()
    }

    fun getPasswordsWithRightLength() = arrayOf("qweqweqweqweqwe", "qweqweqwe", "1ффывфывфывфыв", "123asasdasd1d")

    @Test
    @Parameters(method = "getPasswordsWithRightLength")
    fun `Validation of length must be passed, if length of password is at least 8 characters`(password: String) {
        assertTrue(
            "The password $password is failed because its length is ${password.length} characters long",
            passwordValidator.validateLength(password)
        )
    }

    fun getPasswordsWithDigits() = arrayOf("qweqweqwe123qweqwe", "asdsadasd1123", "asda1sdasd", "123asasdasd1d")

    @Test
    @Parameters(method = "getPasswordsWithDigits")
    fun `Password must contain at least 1 digit`(password: String) {
        assertTrue(
            "The password $password is failed because it doesn't have a digit",
            passwordValidator.validateDigit(password)
        )
    }

    @Test
    @Parameters(method = "getPasswordsWithDigits")
    fun `Password must contain at least 1 letter`(password: String) {
        assertTrue(
            "The password $password is failed because it doesn't have a letter",
            passwordValidator.validateLetter(password)
        )
    }

    @Test
    @Parameters(method = "getPasswordsWithDigits")
    fun `Password must be validate`(password: String) {
        assertTrue(
            "The password $password is failed",
            passwordValidator.validate(password)
        )
    }
}