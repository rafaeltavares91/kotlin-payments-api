package com.payments.api.entity

enum class PaymentStatus(val code: Int, val description: String) {

    APPROVED(1, "Approved"),
    DENIED(2, "Denied"),
    CANCELLED(3, "Cancelled");

}