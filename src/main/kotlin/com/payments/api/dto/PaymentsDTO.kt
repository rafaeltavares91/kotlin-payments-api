package com.payments.api.dto

data class BoletoDTO(var id: Long, var number: String)

data class BuyerDTO(var id: Int, var name: String, var email: String,  var cpf: String)

data class CardDTO(var id: Int, var holderName: String, var number: String, var expirationDate: String, var cvv: String)

data class ClientDTO(var id: Int)

data class PaymentDTO(var id: String, var amout: String, var type: String, var status: String,
                      var client: ClientDTO, var buyer: BuyerDTO, var card: CardDTO, var boleto: BoletoDTO)