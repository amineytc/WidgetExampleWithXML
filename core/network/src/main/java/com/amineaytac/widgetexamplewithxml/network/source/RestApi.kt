package com.amineaytac.widgetexamplewithxml.network.source

import com.amineaytac.widgetexamplewithxml.network.dto.SentenceResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET(".")
    suspend fun getSentence(): Response<SentenceResponse>
}