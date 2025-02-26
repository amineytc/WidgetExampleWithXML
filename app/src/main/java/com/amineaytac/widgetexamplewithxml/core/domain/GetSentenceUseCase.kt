package com.amineaytac.widgetexamplewithxml.core.domain

import com.amineaytac.widgetexamplewithxml.core.common.ResponseState
import com.amineaytac.widgetexamplewithxml.core.data.model.Sentence
import com.amineaytac.widgetexamplewithxml.core.data.repo.SentenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSentenceUseCase @Inject constructor(private val repository: SentenceRepository) {
    suspend operator fun invoke(): Flow<ResponseState<Sentence>> {
        return repository.getSentence()
    }
}