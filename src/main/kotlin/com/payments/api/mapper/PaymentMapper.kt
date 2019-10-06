package com.payments.api.mapper

import com.payments.api.dto.PaymentDTO
import com.payments.api.entity.Payment
import com.payments.api.entity.PaymentStatus
import com.payments.api.entity.PaymentType

fun Payment.toDTO() = PaymentDTO(
        id = id,
        amount = amount,
        type = type.description,
        status = status.description,
        clientDTO = client.toDTO(),
        buyerDTO = buyer.toDTO(),
        cardDTO = card!!.toDTO(),
        boletoDTO = boleto!!.toDTO()
)

fun PaymentDTO.toPayment() = Payment(
        id = id,
        amount = amount,
        type = PaymentType.valueOf(type),
        status = status?.let { PaymentStatus.valueOf(it) }!!,
        client = clientDTO.toClient(),
        buyer = buyerDTO.toBuyer(),
        card = cardDTO!!.toCard(),
        boleto = boletoDTO!!.toBoleto()
)