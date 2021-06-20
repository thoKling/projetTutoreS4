package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.TicketReqDto
import com.example.projet_tutore_back.data.entity.Ticket
import com.example.projet_tutore_back.data.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ticket")
class TicketWS @Autowired constructor(
    val ticketService: TicketService
)
{
    @PostMapping("/create")
    fun createTicket(@RequestBody ticketReq: TicketReqDto) {
        ticketService.createTicket(ticketReq)
    }

    @GetMapping("/getTicketsForUser")
    fun getTicketsForUser(): List<Ticket> {
        return ticketService.getTicketsForUser()
    }

    @GetMapping("/getTicket/{id}")
    fun getTicket(@PathVariable id: Long): Ticket? {
        return ticketService.getTicket(id)
    }
}
