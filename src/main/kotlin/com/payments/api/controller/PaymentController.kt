package com.payments.api.controller

import com.payments.api.dto.PaymentDTO
import com.payments.api.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

object PaymentConstants {
    const val PATH = "payments"
}

@RestController
@RequestMapping(PaymentConstants.PATH)
class PaymentController(private val paymentService: PaymentService) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun checkPaymentStatus(@PathVariable id: Long): PaymentDTO {
        return paymentService.findById(id);
    }

}