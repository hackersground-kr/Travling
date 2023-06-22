package com.traveling.presentation.features.main.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traveling.domain.model.Food
import com.traveling.presentation.databinding.ListFoodBinding

class ListFoodAdapter(
    private val foodList: List<Food>
): RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ListFoodBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val detail = binding.detail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            /*itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val food: Food = foodList[curPos]
            }*/
        }
    }

    override fun getItemCount() = foodList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = foodList[position].foodname
        holder.detail.text = foodList[position].foodcontent
    }
}