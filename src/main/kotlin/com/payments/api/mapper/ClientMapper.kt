package com.payments.api.mapper

import com.payments.api.dto.ClientDTO
import com.payments.api.entity.Client

fun Client.toDTO() = ClientDTO(
        id = id
)

fun ClientDTO.toClient() = Client(
        id = id
)