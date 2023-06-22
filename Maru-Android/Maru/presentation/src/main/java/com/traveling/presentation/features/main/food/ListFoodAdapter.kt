package com.traveling.presentation.features.main.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.traveling.domain.model.Food
import com.traveling.presentation.databinding.ListFoodBinding

class ListFoodAdapter(
    private val foodList: List<Food>,
    private val mb: String,
): RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {
    var foodBackground: ConstraintLayout? = null
    inner class ViewHolder(private val binding: ListFoodBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val detail = binding.detail
        val food = binding.color
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = foodList[position].foodname
        holder.detail.text = foodList[position].foodtype
        foodBackground = holder.food
    }

    fun changeColor(position: Int) {
        when (position) {
            1 -> foodBackground?.setBackgroundResource(com.traveling.presentation.R.drawable.level1_button)
            2 -> foodBackground?.setBackgroundResource(com.traveling.presentation.R.drawable.level2_button)
            3 -> foodBackground?.setBackgroundResource(com.traveling.presentation.R.drawable.level3_button)
        }
    }
}

