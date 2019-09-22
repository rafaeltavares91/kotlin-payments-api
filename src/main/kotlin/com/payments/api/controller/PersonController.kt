package com.payments.api.controller

import com.payments.api.entity.Person
import com.payments.api.repository.PersonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController(private val personRepository: PersonRepository) {

    @GetMapping
    fun findAll(): Iterable<Person> = personRepository.findAll();

    private fun getPersons(): List<Person> {
        return mutableListOf(
                Person(1, "Rafa", 28),
                Person(2, "Murilo", 24),
                Person(3, "Vanessa", 23))
    }

}