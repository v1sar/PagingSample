package com.example.pagingsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingsample.adapter.BestAdapterEver
import com.example.pagingsample.adapter.FilmPagingSource
import com.example.pagingsample.adapterLoading.BestLoadingAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter = BestAdapterEver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter.withLoadStateFooter(
            footer = BestLoadingAdapter { adapter.retry() }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        val pagerFlow = Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false),
            pagingSourceFactory = { FilmPagingSource() }
        ).flow

        lifecycleScope.launch {
            pagerFlow.collect {
                adapter.submitData(it)
            }
        }
    }
}