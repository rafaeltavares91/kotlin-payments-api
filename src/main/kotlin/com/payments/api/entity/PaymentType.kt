package com.payments.api.entity

enum class PaymentType(val code: Int, val description: String) {

    BOLETO(1, "Boleto"),
    CREDIT_CARD(2, "Credit Card")

}