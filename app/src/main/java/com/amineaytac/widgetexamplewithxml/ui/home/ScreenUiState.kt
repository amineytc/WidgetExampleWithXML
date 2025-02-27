package com.amineaytac.widgetexamplewithxml.ui.home

import com.amineaytac.widgetexamplewithxml.core.data.model.Sentence

data class ScreenUiState(
    val sentence: Sentence = Sentence(""),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = ""
) {
    companion object {
        fun initial() = ScreenUiState(isLoading = true)
    }
}