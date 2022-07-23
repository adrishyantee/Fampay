package com.example.fampayproject.api.handlers

import com.example.fampayproject.api.interfaces.CardGroupsInterface
import com.example.fampayproject.models.CardGroups


class CardGroupSource(private val cardgroups: CardGroupsInterface) {
    suspend fun getCardGroups(): CardGroups {
        return cardgroups.getCardGroups()
    }
}