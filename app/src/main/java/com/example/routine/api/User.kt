package com.example.routine.api

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("username" ) var username : String? = null,
    @SerializedName("email"    ) var email    : String? = null,
    @SerializedName("birthday" ) var birthday : String? = null

)