package com.htmltoapk.data.model

seal class UiState<out T> {
    data class Loading<T>(val message: String = "Loading...") : UiState<T>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error<T>(val exception: Exception, val message: String = exception.message ?: "Unknown error") : UiState<T>()
    data class Idle<T>(val data: T? = null) : UiState<T>()
}