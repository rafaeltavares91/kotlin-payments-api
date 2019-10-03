package com.payments.api.mapper

import com.payments.api.dto.CardDTO
import com.payments.api.entity.Card

fun Card.toDTO() = CardDTO(
        id = id,
        holderName = holderName,
        number = number,
        expirationDate = expirationDate,
        ccv = ccv
)

fun CardDTO.toCard() = Card(
        id = id,
        holderName = holderName,
        number = number,
        expirationDate = expirationDate,
        ccv = ccv
)