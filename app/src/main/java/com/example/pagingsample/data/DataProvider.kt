package com.example.pagingsample.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object DataProvider {

    suspend fun getData(offset: Int, size: Int) =
        withContext(Dispatchers.Default) {
            println("Get data called with offset: $offset and size: $size")
            delay(1500)
            listWithData.subList(
                offset.coerceAtMost(listWithData.size),
                (offset + size)
            )
        }

    private val listWithData = listOf(
        FilmModel(
            title = "Film1",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film2",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film3",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film4",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film5",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film6",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film7",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film8",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film9",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film10",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film11",
            subtitle = "Awesome film"
        ), FilmModel(
            title = "Film12",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film13",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film14",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film15",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film16",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film17",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film18",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film19",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film20",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film21",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film22",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film23",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film24",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film25",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film26",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film27",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film28",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film29",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film30",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film31",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film32",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film33",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film34",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film35",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film36",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Film37",
            subtitle = "Awesome film"
        )
    )
}