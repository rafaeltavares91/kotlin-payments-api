package com.payments.api.entity

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
data class Buyer (

    @Id
    @GeneratedValue
    var id: Long? = null,

    @NotBlank
    var name: String,

    @Email
    var email: String,

    @CPF
    var cpf: String

)