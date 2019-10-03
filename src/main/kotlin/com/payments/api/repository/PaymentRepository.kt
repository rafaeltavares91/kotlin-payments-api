package com.payments.api.repository

import com.payments.api.entity.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Long>