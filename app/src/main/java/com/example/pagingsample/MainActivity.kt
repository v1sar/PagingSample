package com.example.pagingsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingsample.adapter.BestAdapterEver
import com.example.pagingsample.adapter.FilmPositionalDataSource
import com.example.pagingsample.data.FilmModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = BestAdapterEver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataSource = FilmPositionalDataSource()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(5)
            .build()

        val pagedList : PagedList<FilmModel> = PagedList.Builder(dataSource, config)
            .build()

        adapter.submitList(pagedList)
    }
}