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
import com.traveling.presentation.R

class NewsAdapter(private val newsList: List<Article>, private val activity: Activity) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("엄어멍ㅁ", "onBindViewHolder: 아아ㅏ아")
        val newsTitle = newsList[position]
        holder.titleTextView.text = newsList[position].title
        holder.titleTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW  , Uri.parse(newsList[position].url))
            activity.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.news_title)
    }
}