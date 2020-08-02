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
            title = "Android 10",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 11",
            subtitle = "Awesome film"
        ), FilmModel(
            title = "Android 12",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 13",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 14",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 15",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 16",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 17",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 18",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 19",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 20",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 21",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 22",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 23",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 24",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 25",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 26",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 27",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 28",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 29",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 30",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 31",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 32",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 33",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 34",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 35",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 36",
            subtitle = "Awesome film"
        ),
        FilmModel(
            title = "Android 37",
            subtitle = "Awesome film"
        )
    )
}