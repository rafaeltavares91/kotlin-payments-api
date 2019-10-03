package com.payments.api.mapper

import com.payments.api.dto.BuyerDTO
import com.payments.api.entity.Buyer

fun Buyer.toDTO() = BuyerDTO(
        id = id,
        name = name,
        email = email,
        cpf = cpf
)

fun BuyerDTO.toBuyer() = Buyer(
        id = id,
        name = name,
        email = email,
        cpf = cpf
)