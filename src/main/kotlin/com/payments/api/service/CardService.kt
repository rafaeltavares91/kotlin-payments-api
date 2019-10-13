package com.payments.api.service

import com.payments.api.dto.CardDTO
import com.payments.api.entity.Card
import com.payments.api.mapper.toCard
import com.payments.api.repository.CardRepository
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class CardService(private val cardRepository: CardRepository) {

    fun findByNumber(number: String?): Card? {
        if(StringUtils.isEmpty(number))
            return null
        return cardRepository
                .findByNumber(number!!)
    }

    fun deleteAll() {
        cardRepository.deleteAll();
    }

    fun save(cardDTO: CardDTO) {
        cardRepository.save(cardDTO.toCard())
    }

}