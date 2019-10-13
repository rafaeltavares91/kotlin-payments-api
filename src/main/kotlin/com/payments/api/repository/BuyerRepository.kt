package com.payments.api.repository

import com.payments.api.entity.Buyer
import org.springframework.data.repository.CrudRepository

interface BuyerRepository : CrudRepository<Buyer, Long> {
    fun findByCpf(cpf: String): Buyer
}