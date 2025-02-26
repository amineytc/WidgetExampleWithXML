package com.amineaytac.widgetexamplewithxml.core.network.source

import com.amineaytac.widgetexamplewithxml.core.network.dto.SentenceResponse
import retrofit2.Response
import javax.inject.Inject

class RestDataSourceImpl @Inject constructor(private val restApi: RestApi) : RestDataSource {

    override suspend fun getSentence(): Response<SentenceResponse> {
        return restApi.getSentence()
    }
}