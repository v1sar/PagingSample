package com.example.pagingsample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingsample.adapter.BestAdapterEver
import com.example.pagingsample.adapter.FilmPagingSource
import com.example.pagingsample.adapterLoading.BestLoadingAdapter
import com.example.pagingsample.data.UiModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter = BestAdapterEver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.addLoadStateListener { state ->
            pb_initial_loading.visibility =
                if (state.source.refresh is LoadState.Loading) View.VISIBLE else View.INVISIBLE
        }

        recyclerView.adapter = adapter.withLoadStateFooter(
            footer = BestLoadingAdapter { adapter.retry() }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        val pagerFlow = Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false),
            pagingSourceFactory = { FilmPagingSource() }
        ).flow
            .map { pagingData ->
                pagingData.map { filmModel -> UiModel.FilmModelItem(filmModel) }
            }
            .map {
                it.insertSeparators<UiModel.FilmModelItem, UiModel> { filmModelItem1, filmModelItem2 ->
                    if (filmModelItem1 == null || filmModelItem2 == null) {
                        return@insertSeparators null
                    }

                    if (filmModelItem2.filmModel.title.length > filmModelItem1.filmModel.title.length) {
                        UiModel.DummySeparator("Title Length differs")
                    } else {
                        null
                    }
                }
            }

        lifecycleScope.launch {
            pagerFlow.collect {
                adapter.submitData(it)
            }
        }
    }
}