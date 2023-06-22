package com.traveling.presentation.features.onboard.health.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.traveling.presentation.R
import com.traveling.presentation.features.onboard.health.HealthClickListenr


class DiseaseAdapter(
    private var list: List<String>,
    private var clickListenr: HealthClickListenr
): RecyclerView.Adapter<DiseaseAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var checkBox: CheckBox
        init { checkBox = view.findViewById(R.id.disease_checkBox) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_disease, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.text = list[position]
        holder.checkBox.setOnCheckedChangeListener { _, _ ->
            clickListenr.checkBoxCheckChange(holder.checkBox.text as String, holder.checkBox)
        }
    }

    override fun getItemCount() = list.size
}

