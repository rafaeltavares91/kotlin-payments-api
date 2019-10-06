package com.payments.api.initializer

import com.payments.api.dto.BuyerDTO
import com.payments.api.dto.CardDTO
import com.payments.api.dto.ClientDTO
import com.payments.api.dto.PaymentDTO
import com.payments.api.service.PaymentService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*

@Component
@ConditionalOnProperty(value = "spring.datasource.initialization-mode",
        havingValue = "always",
        matchIfMissing = false)
class DbInitializer (var paymentService: PaymentService) : CommandLineRunner{

    override fun run(vararg args: String?) {
        paymentService.deleteAll()
        val payment = PaymentDTO(id = null,
                amount = BigDecimal(1000),
                type = "Credit Card",
                status = null,
                clientDTO = ClientDTO(id = null),
                buyerDTO = BuyerDTO(id = null, name = "Vanessa", email = "teste@email.com", cpf = "12345678900"),
                cardDTO = CardDTO(id = null,
                        holderName = "Vanessa X. X. X",
                        number = "12345678901234",
                        expirationDate = Date(),
                        ccv = "123"),
                boletoDTO = null
                )
        paymentService.save(payment)

        println(" -- Database has been initialized")
    }
}
