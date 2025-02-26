package com.amineaytac.widgetexamplewithxml.core.network.source

import com.amineaytac.widgetexamplewithxml.core.network.dto.SentenceResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET(".")
    suspend fun getSentence(): Response<SentenceResponse>
}