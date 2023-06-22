package com.traveling.presentation.features.onboard.health

import android.widget.CheckBox

interface HealthClickListener {
    fun checkBoxCheckChange(name: String, checkBox: CheckBox)
}