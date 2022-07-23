package com.example.fampayproject.models

import com.google.gson.annotations.SerializedName

// not required now

data class CardGroups(
    @SerializedName("card_groups")
    val card_groups: List<CardGroup>
)