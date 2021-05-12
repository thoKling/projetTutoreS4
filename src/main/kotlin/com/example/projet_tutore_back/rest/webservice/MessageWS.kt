package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.repository.MessageRepository
import com.example.projet_tutore_back.data.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageWS(
    @Autowired
    val messageService: MessageService
) {
    @PostMapping("/send")
    fun sendMessage(@RequestBody message: Message) : String {
        messageService.sendMessage(message)
        return ""
    }
}
