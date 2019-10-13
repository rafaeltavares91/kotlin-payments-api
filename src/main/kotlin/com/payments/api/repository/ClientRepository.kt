package com.payments.api.repository

import com.payments.api.entity.Client
import org.springframework.data.repository.CrudRepository

interface ClientRepository : CrudRepository<Client, Long> {
    fun findById(id: Int): Client
}

