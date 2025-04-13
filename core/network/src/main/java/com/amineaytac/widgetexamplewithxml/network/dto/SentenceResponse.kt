package com.amineaytac.widgetexamplewithxml.network.dto

import com.google.gson.annotations.SerializedName

data class SentenceResponse(
    @SerializedName("affirmation")
    val affirmation: String?
)