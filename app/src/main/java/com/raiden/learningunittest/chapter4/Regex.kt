package com.raiden.learningunittest.chapter4

class Regex {

    fun getNumber(string: String): List<Int> {
        val numbers = arrayListOf<Int>()
        val regex = "\\d{3,}".toRegex()
        regex.findAll(string)
            .map { it.value }
            .map { it.toIntOrNull() }
            .forEach { number ->
                number?.let {
                    numbers.add(it)
                }
            }
        return numbers
    }
}