package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.dto.TicketReqDto
import com.example.projet_tutore_back.data.entity.Ticket
import com.example.projet_tutore_back.data.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class TicketService @Autowired constructor (
    val ticketRepository: TicketRepository
    ) {
    fun createTicket(ticketReqDto: TicketReqDto) {
        ticketRepository.save(
            Ticket(
                null,
                false,
                0,
                ticketReqDto.title,
                ticketReqDto.demand,
                SecurityContextHolder.getContext().authentication.name.split('|')[1],
                null
            )
        )
    }

    fun getTicketsForUser() : List<Ticket> {
        // User id that sends the request
        val senderId = SecurityContextHolder.getContext().authentication.name.split('|')[1]
        return ticketRepository.findAllBySenderId(senderId)
    }

    fun getTicket(ticketId: Long) : Ticket? {
        return ticketRepository.findById(ticketId).get()
    }
}
