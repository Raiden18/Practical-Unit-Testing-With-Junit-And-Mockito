package com.raiden.learningunittest.chapter8.exercise3

import java.util.*

object MapUtil {
    fun <K, V : Comparable<V>> reverseSortByValue(map: Map<K, V>): Map<K, V> {
        val list = ArrayList<Map.Entry<K, V>>(map.entries)
        list.sortBy { it.value }
        list.reverse()
        val result = LinkedHashMap<K, V>()
        for (entry in list) {
            result[entry.key] = entry.value
        }

        return result
    }
}
