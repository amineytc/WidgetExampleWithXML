package com.amineaytac.widgetexamplewithxml.util

import android.view.View
import com.amineaytac.widgetexamplewithxml.core.data.model.Sentence
import com.amineaytac.widgetexamplewithxml.core.network.dto.SentenceResponse
import retrofit2.Response

typealias RestResponse = Response<SentenceResponse>

fun RestResponse.toSentence(): Sentence {
    return Sentence(
        affirmation = body()?.affirmation.toString()
    )
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}