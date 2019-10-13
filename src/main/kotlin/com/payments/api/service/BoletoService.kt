package com.payments.api.service

import com.payments.api.dto.BoletoDTO
import com.payments.api.entity.Boleto
import com.payments.api.mapper.toBoleto
import com.payments.api.repository.BoletoRepository
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class BoletoService(private val boletoRepository: BoletoRepository) {

    fun findByNumber(number: String?): Boleto? {
        if(StringUtils.isEmpty(number))
            return null
        return boletoRepository
                .findByNumber(number!!)
    }

    fun deleteAll() {
        boletoRepository.deleteAll();
    }

    fun save(boletoDTO: BoletoDTO) {
        boletoRepository.save(boletoDTO.toBoleto())
    }

}