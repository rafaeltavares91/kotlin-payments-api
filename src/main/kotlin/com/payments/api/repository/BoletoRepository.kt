package com.payments.api.repository

import com.payments.api.entity.Boleto
import org.springframework.data.repository.CrudRepository

interface BoletoRepository : CrudRepository<Boleto, Long> {
    fun findByNumber(number: String): Boleto
}