package com.traveling.presentation.features.main.food

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.traveling.domain.model.Food
import com.traveling.presentation.R
import com.traveling.presentation.databinding.ListFoodBinding

class ListFoodAdapter(
    private val context: Context,
    private val foodList: List<Food>,
    private val viewModel: FoodViewModel,
    private val action: (String, String) -> (Unit)
): RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ListFoodBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val detail = binding.detail
        val food = binding.color
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val food = foodList[adapterPosition]
                action(food.foodname, food.foodcontent)
            }
        }
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = foodList[position].foodname
        holder.detail.text = foodList[position].foodtype
        val foodBackground = holder.food

        when (viewModel.mode.value) {
            1 -> foodBackground.background = context.resources.getDrawable(R.drawable.level1_button)
            2 -> foodBackground.background = context.resources.getDrawable(R.drawable.level2_button)
            3 -> foodBackground.background = context.resources.getDrawable(R.drawable.level3_button)
        }
    }
}

