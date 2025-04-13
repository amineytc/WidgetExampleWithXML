package com.amineaytac.widgetexamplewithxml.data.repo

import com.amineaytac.widgetexamplewithxml.common.ResponseState
import com.amineaytac.widgetexamplewithxml.data.model.Sentence
import kotlinx.coroutines.flow.Flow

interface SentenceRepository {
    suspend fun getSentence(): Flow<ResponseState<Sentence>>
}