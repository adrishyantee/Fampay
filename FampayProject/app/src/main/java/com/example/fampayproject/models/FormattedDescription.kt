package com.example.fampayproject.api.models

data class FormattedDescription(
    val align: String,
    val entities: List<Entity>,
    val text: String
)