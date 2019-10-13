package com.payments.api.service

import com.payments.api.dto.BuyerDTO
import com.payments.api.entity.Buyer
import com.payments.api.mapper.toBuyer
import com.payments.api.repository.BuyerRepository
import org.springframework.stereotype.Service

@Service
class BuyerService(private val buyerRepository: BuyerRepository) {

    fun findByCpf(cpf: String): Buyer {
        return buyerRepository
                .findByCpf(cpf)
    }

    fun deleteAll() {
        buyerRepository.deleteAll();
    }

    fun save(buyerDTO: BuyerDTO) {
        buyerRepository.save(buyerDTO.toBuyer())
    }

}