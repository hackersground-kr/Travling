package com.traveling.presentation.features.main.news

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.traveling.domain.parsing.Article
import com.traveling.domain.parsing.news
import com.traveling.presentation.R

class NewsAdapter(private val newsList: List<Article>, private val activity: Activity, private val callback: (String) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    val TAG: String = "로그"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsTitle = newsList[position]
        holder.titleTextView.text = newsList[position].title
        holder.titleTextView.setOnClickListener {
            Log.d(TAG, "NewsAdapter - ${newsTitle.url.toString()}() called")
            callback(newsTitle.url)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.news_title)
    }
}