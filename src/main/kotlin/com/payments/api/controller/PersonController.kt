package com.payments.api.controller

import com.payments.api.entity.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController {

    @GetMapping
    fun findAll(): List<Person> = getPersons()

    private fun getPersons(): List<Person> {
        return mutableListOf(
                Person(1, "Rafa", 28),
                Person(2, "Murilo", 24))
    }

}