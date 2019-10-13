package com.payments.api.entity

enum class PaymentStatus(val code: Int, val description: String) {

    APPROVED(1, "Approved"),
    DENIED(2, "Denied"),
    CANCELLED(3, "Cancelled"),
    PENDING(4,"Pending");

    companion object {
        fun fromDescription(description: String):PaymentStatus{
            var enumName: String = description.toUpperCase().replace(" ","_")
            return PaymentStatus.valueOf(enumName)
        }
    }
}