package com.traveling.presentation.features.onboard.health.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.databinding.DialogDiseaseBinding
import com.traveling.presentation.features.onboard.health.HealthFragment
import com.traveling.presentation.wiget.MaruApplication


class DiseaseDialog(
    context: Context,
    private var diseaseMap: HashMap<String, Boolean>,
    private val callback: HealthFragment.OnClickOkListener
) : Dialog(context
) {
    private val binding: DialogDiseaseBinding by lazy { DialogDiseaseBinding.inflate(layoutInflater) }
    private lateinit var adapter: DiseaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        initButtonListener()
    }

    private fun initRecyclerView() {
        adapter = DiseaseAdapter(
            diseaseMap.keys.toList(),
            diseaseMap
        )
        with(binding) {
            diseaseRv.adapter = adapter
            diseaseRv.layoutManager= LinearLayoutManager(context)
        }
    }

    private fun initButtonListener() {
        binding.diseaseNoBtn.setOnClickListener {
            dismiss()
        }

        binding.diseaseYesBtn.setOnClickListener {
            MaruApplication.prefs.md1 = diseaseMap.map { it.key }.joinToString(",")
            callback.onClick()
            dismiss()
        }
    }
}