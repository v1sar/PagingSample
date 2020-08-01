package com.example.pagingsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingsample.R
import com.example.pagingsample.data.FilmModel
import com.example.pagingsample.data.UiModel
import java.lang.IllegalStateException

class BestAdapterEver : PagingDataAdapter<UiModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UiModel.FilmModelItem -> 1
            is UiModel.DummySeparator -> 2
            null -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val uiModel = getItem(position)
        uiModel.let {
            when (uiModel) {
                is UiModel.FilmModelItem -> (holder as UsualViewHolder).bind(uiModel.filmModel)
                is UiModel.DummySeparator -> (holder as SeparatorViewHolder).bind(uiModel.title)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
            UsualViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.separator_item, parent, false)
            SeparatorViewHolder(view)
        }
    }

    class UsualViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val subtitle = view.findViewById<TextView>(R.id.subtitle)

        fun bind(filmModel: FilmModel) {
            title.text = filmModel.title
            subtitle.text = filmModel.subtitle
        }
    }

    class SeparatorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val separatorText = view.findViewById<TextView>(R.id.tv_separator)

        fun bind(text: String) {
            separatorText.text = text
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UiModel>() {
            override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean =
                (oldItem is UiModel.FilmModelItem && newItem is UiModel.FilmModelItem && oldItem.filmModel.title == newItem.filmModel.title) ||
                        (oldItem is UiModel.DummySeparator && newItem is UiModel.DummySeparator && oldItem.title == newItem.title)

            override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean =
                oldItem == newItem
        }
    }
}