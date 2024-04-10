package com.example.routine.api

import com.google.gson.annotations.SerializedName


data class Event (
    @SerializedName("id"    ) var id    : Int,
    @SerializedName("title" ) var title : String? = null,
    @SerializedName("image" ) var image : String? = null
)
