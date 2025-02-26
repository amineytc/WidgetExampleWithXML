package com.amineaytac.widgetexamplewithxml.core.network.source

import com.amineaytac.widgetexamplewithxml.core.network.dto.SentenceResponse
import retrofit2.Response

interface RestDataSource {
    suspend fun getSentence(): Response<SentenceResponse>
}