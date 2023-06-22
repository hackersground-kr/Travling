package com.traveling.presentation.features.onboard.health

import android.widget.CheckBox

interface HealthClickListenr {
    fun checkBoxCheckChange(name: String, checkBox: CheckBox)
}