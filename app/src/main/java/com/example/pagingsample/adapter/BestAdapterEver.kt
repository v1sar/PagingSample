package com.example.pagingsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingsample.R
import com.example.pagingsample.data.FilmModel

class BestAdapterEver : PagedListAdapter<FilmModel, BestAdapterEver.UsualViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: UsualViewHolder, position: Int) {
        val film = getItem(position)
        if (film != null) {
            holder.bind(film)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsualViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return UsualViewHolder(view)
    }

    class UsualViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val subtitle = view.findViewById<TextView>(R.id.subtitle)

        fun bind(filmModel: FilmModel) {
            title.text = filmModel.title
            subtitle.text = filmModel.subtitle
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmModel>() {
            override fun areItemsTheSame(oldItem: FilmModel, newItem: FilmModel): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: FilmModel, newItem: FilmModel): Boolean =
                oldItem == newItem
        }
    }
}