package com.payments.api.mapper

import com.payments.api.dto.PaymentDTO
import com.payments.api.entity.Payment

fun Payment.toDTO() = PaymentDTO(
        amount = amount,
        type = type.description,
        status = status.description,
        clientDTO = client.toDTO(),
        buyerDTO = buyer.toDTO(),
        cardDTO = card!!.toDTO(),
        boletoDTO = boleto!!.toDTO()
)
