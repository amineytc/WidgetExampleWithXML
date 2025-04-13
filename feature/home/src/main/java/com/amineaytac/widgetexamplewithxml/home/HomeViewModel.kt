package com.amineaytac.widgetexamplewithxml.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amineaytac.widgetexamplewithxml.common.ResponseState
import com.amineaytac.widgetexamplewithxml.domain.GetSentenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSentenceUseCase: GetSentenceUseCase
) : ViewModel() {

    private val _screenUiState = MutableLiveData(ScreenUiState.initial())
    val screenUiState: LiveData<ScreenUiState> get() = _screenUiState

    fun getSentence() {
        viewModelScope.launch {
            getSentenceUseCase().collect { responseState ->
                when (responseState) {
                    is ResponseState.Error -> {
                        _screenUiState.postValue(
                            ScreenUiState(
                                isError = true,
                                errorMessage = responseState.message
                            )
                        )
                    }

                    is ResponseState.Loading -> {
                        _screenUiState.postValue(ScreenUiState(isLoading = true))
                    }

                    is ResponseState.Success -> {
                        _screenUiState.postValue(
                            ScreenUiState(sentence = responseState.data)
                        )
                    }
                }
            }
        }
    }

    fun getNewSentence() {
        getSentence()
    }
}