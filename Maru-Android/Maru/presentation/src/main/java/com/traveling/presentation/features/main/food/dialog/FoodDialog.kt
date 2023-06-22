package com.traveling.presentation.features.main.food.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.databinding.DialogDiseaseBinding
import com.traveling.presentation.features.onboard.health.HealthClickListenr


class FoodDialog(context: Context, title: String, food: String) : Dialog(context) {

    private lateinit var binding: DialogDiseaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}