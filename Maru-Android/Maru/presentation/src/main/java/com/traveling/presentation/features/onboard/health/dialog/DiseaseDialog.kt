package com.traveling.presentation.features.onboard.health.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.databinding.adapters.LinearLayoutBindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.databinding.DialogDiseaseBinding
import com.traveling.presentation.features.onboard.health.HealthClickListenr


class DiseaseDialog(
    context: Context,
    private var list: Map<String, String>,
    private var listenr: HealthClickListenr) : Dialog(context) {
    private lateinit var binding: DialogDiseaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val s = DiseaseAdapter(list.keys.toList(), listenr)
        with(binding.diseaseRv) {
            adapter = s
            layoutManager= LinearLayoutManager(context)
        }
    }
}