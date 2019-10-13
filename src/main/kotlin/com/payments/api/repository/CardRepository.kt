package com.payments.api.repository

import com.payments.api.entity.Card
import org.springframework.data.repository.CrudRepository

interface CardRepository : CrudRepository<Card, Long> {
    fun findByNumber(number: String): Card
}