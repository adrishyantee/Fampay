package com.example.fampayproject.api.models

data class CardGroup(
    val cards: List<Card>,
    val design_type: String,
    val height: Int,
    val id: Int,
    val is_scrollable: Boolean,
    val name: String
)