package com.krish.borutoapp.data.local

import androidx.room.TypeConverter

/**
 * Why we need type convertors ?
 * Because in our entity few attributes have List as their Data type
 * and database doesn't know how to store List inside a database
 *
 * so what we do is we convert that list into string when we insert the data
 * List -> String
 *
 * And when we want to fetch the data from the database we convert that
 * String -> List
 * */
class DatabaseConvertor {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuild = StringBuilder()
        for (item in list) {
            stringBuild.append(item).append(separator)
        }
        stringBuild.setLength(stringBuild.length - separator.length)
        return stringBuild.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }
}