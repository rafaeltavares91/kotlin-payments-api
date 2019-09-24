package com.payments.api.entity

import javax.persistence.*

@Entity
data class Person(

    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,

    var age: Int

)