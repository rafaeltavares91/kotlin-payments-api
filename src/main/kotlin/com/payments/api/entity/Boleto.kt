package com.payments.api.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotEmpty

@Entity
data class Boleto (

    @Id
    @GeneratedValue
    var id: Long? = null,

    @NotEmpty
    var number: String

)