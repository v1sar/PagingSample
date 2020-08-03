package com.example.pagingsample.adapter

import android.util.Log
import androidx.paging.PagingSource
import com.example.pagingsample.data.DataProvider
import com.example.pagingsample.data.FilmModel

class FilmPagingSource : PagingSource<Int, FilmModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmModel> {
        val offset = params.key ?: 0

        Log.d(FilmPagingSource::class.java.simpleName, "params.key = ${params.key} params.loadSize = ${params.loadSize}")

        val data = DataProvider.getData(offset, params.loadSize)

        return LoadResult.Page(
            data = data,
            prevKey = if (offset == 0) null else offset - params.loadSize,
            nextKey = if (data.isEmpty()) null else offset + params.loadSize
        )
    }
}