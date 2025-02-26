package com.amineaytac.widgetexamplewithxml.core.network.dto

import com.google.gson.annotations.SerializedName

data class SentenceResponse(
    @SerializedName("affirmation")
    val affirmation: String?
)