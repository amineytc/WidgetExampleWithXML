package com.amineaytac.widgetexamplewithxml.domain

import com.amineaytac.widgetexamplewithxml.common.ResponseState
import com.amineaytac.widgetexamplewithxml.data.model.Sentence
import com.amineaytac.widgetexamplewithxml.data.repo.SentenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSentenceUseCase @Inject constructor(private val repository: SentenceRepository) {
    suspend operator fun invoke(): Flow<ResponseState<Sentence>> {
        return repository.getSentence()
    }
}