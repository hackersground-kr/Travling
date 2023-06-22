package com.traveling.presentation.features.main.news

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.traveling.domain.parsing.Article
import com.traveling.presentation.databinding.ListFoodBinding
import com.traveling.presentation.databinding.ListNewsBinding
import dagger.hilt.android.lifecycle.HiltViewModel


class ListNewsAdapter(
    private val context: Context,
    private var newsList: List<Article>,
    private var viewModel: NewsViewModel
    ): RecyclerView.Adapter<ListNewsAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ListNewsBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.newsTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val news = newsList[adapterPosition]
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.url))
                Activity().startActivity(intent)
                //웹사이트 넘기기
            }
        }
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = newsList[position].title
    }


}