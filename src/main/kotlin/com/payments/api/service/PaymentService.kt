package com.payments.api.service

import com.payments.api.dto.PaymentDTO
import com.payments.api.entity.*
import com.payments.api.mapper.toDTO
import com.payments.api.repository.*
import org.springframework.stereotype.Service
import java.lang.NullPointerException

@Service
class PaymentService(private val paymentRepository: PaymentRepository,
                     private var clientService: ClientService,
                     private var buyerService: BuyerService,
                     private var cardService: CardService,
                     private var boletoService: BoletoService) {

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
        val payment = Payment(
            amount = paymentDTO.amount,
            type = PaymentType.fromDescription(paymentDTO.type),
            status = PaymentStatus.fromDescription(paymentDTO.status),
            client = clientService.findById(paymentDTO.clientDTO.id),
            buyer = buyerService.findByCpf(paymentDTO.buyerDTO.cpf),
            card = cardService.findByNumber(paymentDTO.cardDTO?.number),
            boleto = boletoService.findByNumber(paymentDTO.boletoDTO?.number)
        )
        paymentRepository.save(payment)
    }

}