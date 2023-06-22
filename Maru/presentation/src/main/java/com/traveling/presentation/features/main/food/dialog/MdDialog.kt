package com.traveling.presentation.features.main.food.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.databinding.DialogFoodBinding
import com.traveling.presentation.features.main.food.FoodViewModel
import com.traveling.presentation.wiget.MaruApplication


class MdDialog(
    context: Context,
    private val viewModel: FoodViewModel
    ) : Dialog(context) {

    private val binding: DialogFoodBinding by lazy { DialogFoodBinding.inflate(layoutInflater) }

    private lateinit var adapter: MdAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = MdAdapter(MaruApplication.prefs.md1.replace(" ", "").split(","), viewModel)
        with(binding) {
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(context)
        }
    }
}