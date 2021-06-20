package com.example.projet_tutore_back.data.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TicketResponse (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var ticketResponseId: Long?,
)
