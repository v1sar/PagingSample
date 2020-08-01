package com.example.pagingsample.data

sealed class UiModel {
    data class FilmModelItem(val filmModel: FilmModel) : UiModel()
    data class DummySeparator(val title: String) : UiModel()
}