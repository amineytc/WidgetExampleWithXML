package com.amineaytac.widgetexamplewithxml.network.source

import com.amineaytac.widgetexamplewithxml.network.dto.SentenceResponse
import retrofit2.Response
import javax.inject.Inject

class RestDataSourceImpl @Inject constructor(private val restApi: RestApi) : RestDataSource {

    override suspend fun getSentence(): Response<SentenceResponse> {
        return restApi.getSentence()
    }
}