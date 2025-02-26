package com.amineaytac.widgetexamplewithxml.core.data.repo

import com.amineaytac.widgetexamplewithxml.core.common.ResponseState
import com.amineaytac.widgetexamplewithxml.core.data.model.Sentence
import kotlinx.coroutines.flow.Flow

interface SentenceRepository {
    suspend fun getSentence(): Flow<ResponseState<Sentence>>
}