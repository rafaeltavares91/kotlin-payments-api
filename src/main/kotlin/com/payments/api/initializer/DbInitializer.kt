package com.payments.api.initializer

import com.payments.api.entity.*
import com.payments.api.repository.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*

@Component
@ConditionalOnProperty(value = "spring.datasource.initialization-mode",
        havingValue = "always",
        matchIfMissing = false)
class DbInitializer (private var paymentRepository: PaymentRepository,
                     private var clientRepository: ClientRepository,
                     private var buyerRepository: BuyerRepository,
                     private var cardRepository: CardRepository,
                     private var boletoRepository: BoletoRepository
                     ) : CommandLineRunner{

    override fun run(vararg args: String?) {
        deleteAll()
        createAndSavePayments()
    }

    private fun deleteAll(){
        paymentRepository.deleteAll()
        clientRepository.deleteAll()
        buyerRepository.deleteAll()
        cardRepository.deleteAll()
        boletoRepository.deleteAll()
    }

    private fun createAndSavePayments() {
        paymentRepository.save(
            Payment(
                amount = BigDecimal(1000),
                type = PaymentType.CREDIT_CARD,
                status = PaymentStatus.PENDING,
                client = createAndSaveClient(),
                buyer = createAndSaveBuyer("Vanessa", "teste@gmail.com", "9820938193"),
                card = createAndSaveCard()
            )
        )
        paymentRepository.save(
            Payment(
                    amount = BigDecimal(1213),
                    type = PaymentType.BOLETO,
                    status = PaymentStatus.PENDING,
                    client = createAndSaveClient(),
                    buyer = createAndSaveBuyer("Rafael", "teste@gmail.com", "38472844324"),
                    boleto = createAndSaveBoleto()
            )
        )
    }


    private fun createAndSaveClient(): Client {
        return clientRepository.save(Client())
    }

    private fun createAndSaveBuyer(name: String, email:String, cpf:String): Buyer {
        return buyerRepository.save(Buyer(name = name,
                                        email = email,
                                        cpf = cpf))
    }

    private fun createAndSaveBoleto(): Boleto {
        return boletoRepository.save(Boleto(number = "12213312131"))
    }

    private fun createAndSaveCard(): Card {
        return cardRepository.save(Card(
                holderName = "Vanessa X. X. X",
                number = "12345678901234",
                expirationDate = Date(),
                ccv = "123"))
    }
}
