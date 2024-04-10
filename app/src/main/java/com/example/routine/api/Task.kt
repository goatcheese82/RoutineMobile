package com.example.routine.api

import com.google.gson.annotations.SerializedName

data class Task (
    @SerializedName("Id"         ) var id        : Int?    = null,
    @SerializedName("start_time" ) var startTime : String? = null,
    @SerializedName("end_time"   ) var endTime   : String? = null,
    @SerializedName("event_id"   ) var eventId   : Int?    = null
)
