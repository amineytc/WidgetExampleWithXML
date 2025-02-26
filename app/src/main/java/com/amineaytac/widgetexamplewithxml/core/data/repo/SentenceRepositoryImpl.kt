package com.amineaytac.widgetexamplewithxml.core.data.repo

import com.amineaytac.widgetexamplewithxml.core.common.ResponseState
import com.amineaytac.widgetexamplewithxml.core.data.model.Sentence
import com.amineaytac.widgetexamplewithxml.core.network.source.RestDataSource
import com.amineaytac.widgetexamplewithxml.util.toSentence
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(private val restDataSource: RestDataSource) :
    SentenceRepository {
    override suspend fun getSentence(): Flow<ResponseState<Sentence>> {
        return flow {
            emit(ResponseState.Loading)

            val response = restDataSource.getSentence()
            emit(ResponseState.Success(response.toSentence()))

        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }
}