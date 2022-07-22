package com.example.fampayproject.api.models

data class FormattedTitle(
    val align: String,
    val entities: List<Entity>,
    val text: String
)