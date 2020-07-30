package com.example.pagingsample.adapter

import androidx.paging.PositionalDataSource
import com.example.pagingsample.data.DataProvider
import com.example.pagingsample.data.FilmModel

class FilmPositionalDataSource : PositionalDataSource<FilmModel>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<FilmModel>) {
        val result: List<FilmModel> = DataProvider.getData(params.requestedStartPosition, params.requestedLoadSize)
        callback.onResult(result, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<FilmModel>) {
        val result: List<FilmModel> = DataProvider.getData(params.startPosition, params.loadSize)
        callback.onResult(result)
    }
}