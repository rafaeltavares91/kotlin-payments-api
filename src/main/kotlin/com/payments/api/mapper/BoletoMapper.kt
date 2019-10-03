package com.payments.api.mapper

import com.payments.api.dto.BoletoDTO
import com.payments.api.entity.Boleto

fun Boleto.toDTO() = BoletoDTO(
        id = id,
        number = number
)

fun BoletoDTO.toBoleto() = Boleto(
        id = id,
        number = number
)