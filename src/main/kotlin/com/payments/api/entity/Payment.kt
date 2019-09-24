package com.payments.api.entity

import javax.validation.Valid
import javax.print.DocFlavor.STRING
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
data class Payment(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,

    @NotNull
    @Min(value = 1)
    var amount: BigDecimal? = null,

    @NotNull
    @Enumerated(EnumType.STRING)
    var type: PaymentType? = null,

    @Enumerated(EnumType.STRING)
    var status: PaymentStatus? = null,

    @Valid
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    var client: Client? = null,

    @Valid
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    var buyer: Buyer? = null,

    @Valid
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = true)
    var card: Card? = null,

    @Valid
    @ManyToOne
    @JoinColumn(name = "boleto_id", nullable = true)
    var boleto: Boleto? = null

)