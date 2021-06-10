package com.example.projet_tutore_back.data.repository

import com.example.projet_tutore_back.data.entity.Ticket
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : CrudRepository<Ticket, Long> {
    fun save(ticket: Ticket) : Ticket
    fun findAllBySenderId(senderId: String) : List<Ticket>
}
