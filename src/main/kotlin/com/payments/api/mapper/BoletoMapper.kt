package com.payments.api.mapper

import com.payments.api.dto.BoletoDTO
import com.payments.api.entity.Boleto

fun Boleto.toDTO() = BoletoDTO(
        number = number
)

fun BoletoDTO.toBoleto() = Boleto(
        number = number
)