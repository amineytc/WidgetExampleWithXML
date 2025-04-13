package com.amineaytac.widgetexamplewithxml.home

import com.amineaytac.widgetexamplewithxml.data.model.Sentence

data class ScreenUiState(
    val sentence: Sentence = Sentence(
        ""
    ),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = ""
) {
    companion object {
        fun initial() = ScreenUiState(isLoading = true)
    }
}