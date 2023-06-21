package com.traveling.data.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(MARU_APP, Context.MODE_PRIVATE)

    var walkCount: String
        get() = prefs.getString(WALK_COUNT, "").toString()
        set(value) = prefs.edit().putString(WALK_COUNT, value).apply()
    var name: String
        get() = prefs.getString(NAME, "").toString()
        set(value) = prefs.edit().putString(NAME, value).apply()
    var age: String
        get() = prefs.getString(AGE, "").toString()
        set(value) = prefs.edit().putString(AGE, value).apply()
    var md1: String
        get() = prefs.getString(MD1, "").toString()
        set(value) = prefs.edit().putString(MD1, value).apply()
    var md2: String
        get() = prefs.getString(MD2, "").toString()
        set(value) = prefs.edit().putString(MD2, value).apply()
    var md3: String
        get() = prefs.getString(MD3, "").toString()
        set(value) = prefs.edit().putString(MD3, value).apply()
    var blood: String
        get() = prefs.getString(BLOOD, "").toString()
        set(value) = prefs.edit().putString(BLOOD, value).apply()
    var weight: String
        get() = prefs.getString(WEIGHT, "").toString()
        set(value) = prefs.edit().putString(WEIGHT, value).apply()
    var height: String
        get() = prefs.getString(HEIGHT, "").toString()
        set(value) = prefs.edit().putString(HEIGHT, value).apply()
    var isFirst: Boolean
        get() = prefs.getBoolean(IS_FIRST, true)
        set(value) = prefs.edit().putBoolean(IS_FIRST, value).apply()

//    fun deleteWalkCount() {
//        prefs.edit().remove(WALK_COUNT).apply()
//    }

    companion object {
        const val MARU_APP = "MARU_APP"
        const val WALK_COUNT = "WALK_COUNT"
        const val NAME = "NAME"
        const val AGE = "AGE"
        const val MD1 = "MD1"
        const val MD2 = "MD2"
        const val MD3 = "MD3"
        const val BLOOD = "BLOOD"
        const val WEIGHT = "WEIGHT"
        const val HEIGHT = "HEIGHT"
        const val IS_FIRST = "ISFIRST"
    }
}