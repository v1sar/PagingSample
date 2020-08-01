package com.example.pagingsample.adapterLoading

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingsample.R

class BestLoadingAdapter(private val retry: () -> Unit) : LoadStateAdapter<BestLoadingAdapter.LoadingViewHolder>() {

    override fun onBindViewHolder(holder: LoadingViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.load_state_item, parent, false)
        return LoadingViewHolder(view, retry)
    }

    class LoadingViewHolder(view: View, retry: () -> Unit) : RecyclerView.ViewHolder(view) {

        private val progressBar = view.findViewById<ProgressBar>(R.id.pb_loading)
        private val retryButton = view.findViewById<Button>(R.id.btn_retry)

        init {
            retryButton.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            when (loadState) {
                is LoadState.NotLoading -> {
                    progressBar.visibility = View.INVISIBLE
                    retryButton.visibility = View.VISIBLE
                }
                LoadState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    retryButton.visibility = View.INVISIBLE
                }
                is LoadState.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    retryButton.visibility = View.VISIBLE
                }
            }
        }
    }
}