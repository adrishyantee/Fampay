package com.example.fampayproject.api.models

data class Card(
    val bg_color: String,
    val bg_image: BgImage,
    val cta: List<Cta>,
    val description: String,
    val formatted_description: FormattedDescription,
    val formatted_title: FormattedTitle,
    val icon: Icon,
    val name: String,
    val title: String,
    val url: String
)