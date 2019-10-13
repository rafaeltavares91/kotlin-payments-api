package com.payments.api.dto

import java.math.BigDecimal
import java.util.*

data class BoletoDTO(var number: String)

data class BuyerDTO(var name: String, var email: String, var cpf: String)

data class CardDTO(var holderName: String, var number: String, var expirationDate: Date, var ccv: String)

data class ClientDTO(var id: Int?)

data class PaymentDTO(var amount: BigDecimal, var type: String, var status: String,
                      var clientDTO: ClientDTO, var buyerDTO: BuyerDTO, var cardDTO: CardDTO?, var boletoDTO: BoletoDTO?)