package com.payments.api.service

import com.payments.api.dto.BuyerDTO
import com.payments.api.dto.CardDTO
import com.payments.api.dto.ClientDTO
import com.payments.api.dto.PaymentDTO
import com.payments.api.entity.*
import com.payments.api.mapper.toDTO
import com.payments.api.mapper.toPayment
import com.payments.api.repository.PaymentRepository
import org.springframework.stereotype.Service
import java.lang.NullPointerException
import java.math.BigDecimal
import java.util.*

@Service
class PaymentService(private val paymentRepository: PaymentRepository) {

    fun findById(id: Long): PaymentDTO {
        return paymentRepository
                .findById(id)
                .orElseThrow{NullPointerException()} //TODO: create ResourceNotFoundException class
                .toDTO()
    }

    fun deleteAll() {
        paymentRepository.deleteAll();
    }

    fun findAll(): Iterable<PaymentDTO> {
        return paymentRepository.findAll().map{payment ->  payment.toDTO()}
    }

    fun save(paymentDTO: PaymentDTO) {
        paymentRepository.save(paymentDTO.toPayment())
    }

}