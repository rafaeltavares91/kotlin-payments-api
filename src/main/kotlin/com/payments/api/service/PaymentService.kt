package com.payments.api.service

import com.payments.api.dto.PaymentDTO
import com.payments.api.mapper.toDTO
import com.payments.api.repository.PaymentRepository
import org.springframework.stereotype.Service
import java.lang.NullPointerException

@Service
class PaymentService(private val paymentRepository: PaymentRepository) {

    fun findById(id: Long): PaymentDTO {
        return paymentRepository
                .findById(id)
                .orElseThrow{NullPointerException()} //TODO: create ResourceNotFoundException class
                .toDTO()
    }

}