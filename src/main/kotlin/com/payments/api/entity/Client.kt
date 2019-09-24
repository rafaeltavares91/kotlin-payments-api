package com.payments.api.entity

import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Client (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

)