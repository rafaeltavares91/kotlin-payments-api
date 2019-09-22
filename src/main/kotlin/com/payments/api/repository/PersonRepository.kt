package com.payments.api.repository

import com.payments.api.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {

}