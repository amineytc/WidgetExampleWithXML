package com.amineaytac.widgetexamplewithxml.network.source

import com.amineaytac.widgetexamplewithxml.network.dto.SentenceResponse
import retrofit2.Response

interface RestDataSource {
    suspend fun getSentence(): Response<SentenceResponse>
}