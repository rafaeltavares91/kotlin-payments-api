package com.payments.api.entity

import org.hibernate.validator.constraints.CreditCardNumber
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.*

@Entity
data class Card (

    @Id
    @GeneratedValue
    var id: Long? = null,

    @NotEmpty
    var holderName: String,

    @NotEmpty
    @NotNull(message = "Credit card number is required")
    @Size(min = 16, max = 16, message = "Credit card number must 16 digits long")
    @Digits(fraction = 0, integer = 16)
    @CreditCardNumber
    @Column(unique=true)
    var number: String,

    @NotNull
    @FutureOrPresent
    var expirationDate: Date,

    @NotNull
    @Size(min = 3, max = 3, message = "CCV card number must 3 digits long")
    var ccv: String

)