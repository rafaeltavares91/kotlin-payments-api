package com.payments.api.entity

enum class PaymentType(val code: Int, val description: String) {

    BOLETO(1, "Boleto"),
    CREDIT_CARD(2, "Credit Card");

    companion object {
        fun fromDescription(description: String):PaymentType{
            var enumName: String = description.toUpperCase().replace(" ","_")
            return valueOf(enumName)
        }
    }
}