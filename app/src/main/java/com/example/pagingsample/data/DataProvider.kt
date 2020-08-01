package com.example.pagingsample.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object DataProvider {

    suspend fun getData(offset: Int, size: Int) =
        withContext(Dispatchers.Default) {
            Log.d(DataProvider.javaClass.simpleName, "Get data called with offset: $offset and size: $size")
            delay(1500)
            listWithData.subList(
                offset.coerceAtMost(listWithData.size),
                (offset + size)
            )
        }

    private val listWithData = listOf(
        FilmModel(
            title = "Star Wars: Android Academy Strikes back",
            subtitle = "Awesome classic"
        ),
        FilmModel(
            title = "The Lord of the Androids: The Return of the AsyncTask",
            subtitle = "Horror (21+)"
        ),
        FilmModel(
            title = "The Dark Knight",
            subtitle = "Story about lovely dark theme"
        ),
        FilmModel(
            title = "Fight Clubdroid",
            subtitle = "An insomniac android developer and a devil-may-care soapmaker"
        ),
        FilmModel(
            title = "The Android Redemption",
            subtitle = "Two imprisoned androids bond over a number of years"
        ),
        FilmModel(
            title = "Inception",
            subtitle = "How to fall into Doze mode inside Doze mode"
        ),
        FilmModel(
            title = "Interstellar",
            subtitle = "Heading to the planet where seconds count as years - good place to wait for Gradle build"
        ),
        FilmModel(
            title = "Pulp Fictiondroid",
            subtitle = "Story about how girl turned into Doze mode"
        ),
        FilmModel(
            title = "The Godfather III",
            subtitle = "The early life and career of Android in 1930s New York City"
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