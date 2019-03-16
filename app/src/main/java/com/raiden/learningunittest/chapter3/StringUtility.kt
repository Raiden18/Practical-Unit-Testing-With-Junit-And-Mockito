package com.raiden.learningunittest.chapter3

class StringUtility {
    fun reverse (string: String): String{
        val tempArray = ArrayList<String>(string.length)
        for (i in 0 until string.length){
            tempArray.add(string.substring(i, i+1))
        }
        val reversedString = StringBuilder(string.length)
        for (i in string.length-1 downTo  0){
            reversedString.append(tempArray[i])
        }
        return reversedString.toString()
    }
}