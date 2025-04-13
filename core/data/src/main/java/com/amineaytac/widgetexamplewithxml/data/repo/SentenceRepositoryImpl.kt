package com.amineaytac.widgetexamplewithxml.data.repo

import com.amineaytac.widgetexamplewithxml.common.ResponseState
import com.amineaytac.widgetexamplewithxml.data.model.Sentence
import com.amineaytac.widgetexamplewithxml.network.dto.SentenceResponse
import com.amineaytac.widgetexamplewithxml.network.source.RestDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
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

typealias RestResponse = Response<SentenceResponse>

fun RestResponse.toSentence(): Sentence {
    return Sentence(
        affirmation = body()?.affirmation.toString()
    )
}