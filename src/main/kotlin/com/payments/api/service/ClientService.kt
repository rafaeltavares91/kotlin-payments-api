package com.payments.api.service

import com.payments.api.dto.ClientDTO
import com.payments.api.entity.Client
import com.payments.api.mapper.toClient
import com.payments.api.repository.ClientRepository
import org.springframework.stereotype.Service
import kotlin.NullPointerException

@Service
class ClientService(private val clientRepository: ClientRepository) {

    fun findById(id: Int?): Client {
        if(id == null)
            throw NullPointerException()
        return clientRepository
                .findById(id!!)
    }

    fun deleteAll() {
        clientRepository.deleteAll()
    }

    fun save(clientDTO: ClientDTO) {
        clientRepository.save(clientDTO.toClient())
    }

}