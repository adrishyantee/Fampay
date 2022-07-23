package com.example.fampayproject.models

enum class DesignTypes(s: String) {
    SMALL_DISPLAY_CARD("HC1"),
    BIG_DISPLAY_CARD("HC3"),
    IMAGE_CARD("HC5"),
    SMALL_CARD_WITH_ARROW("HC6"),
    DYNAMIC_WIDTH_CARD("HC9"
    )
}

data class CardGroup(
    val cards: List<Card>,
    val design_type: String,
    val height: Int,
    val id: Int,
    val is_scrollable: Boolean,

    val name: String
)