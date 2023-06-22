package com.traveling.presentation.features.main.food.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.traveling.presentation.R
import com.traveling.presentation.features.main.food.FoodViewModel

class MdAdapter(
    private var mdList: List<String>,
    private val viewModel: FoodViewModel
): RecyclerView.Adapter<MdAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mdBtn: Button
        init { mdBtn = view.findViewById(R.id.md_btn) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_md, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mdBtn.text = mdList[position]
        holder.mdBtn.setOnClickListener {
            viewModel.md.value = holder.mdBtn.text.toString()
        }
    }

    override fun getItemCount() = mdList.size
}

