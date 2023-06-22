package com.traveling.presentation.features.onboard.health.dialog

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.traveling.presentation.R
import com.traveling.presentation.features.onboard.health.HealthClickListener


class DiseaseAdapter(
    private var list: List<String>,
    private var diseaseMap: HashMap<String, Boolean>,
): RecyclerView.Adapter<DiseaseAdapter.ViewHolder>() {
    val TAG: String = "로그"
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var checkBox: CheckBox
        init { checkBox = view.findViewById(R.id.md_btn) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_disease, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.text = list[position]
        holder.checkBox.setOnCheckedChangeListener { _, check ->
            diseaseMap[list[position]] = check
            Log.d(TAG, "DiseaseAdapter - onBindViewHolder() called")
        }
        holder.checkBox.isChecked = diseaseMap[list[position]]!!
    }

    override fun getItemCount() = list.size
}

