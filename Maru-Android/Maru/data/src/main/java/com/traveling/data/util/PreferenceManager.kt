package com.traveling.data.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(MARU_APP, Context.MODE_PRIVATE)

    var accessToken: String
        get() = prefs.getString(WALK_COUNT, "").toString()
        set(value) = prefs.edit().putString(WALK_COUNT, value).apply()

    fun deleteToken() {
        prefs.edit().remove(WALK_COUNT).apply()
    }

    companion object {
        const val MARU_APP = "MARU_APP"
        const val WALK_COUNT = "WALK_COUNT"
    }
}