package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.repository.MessageRepository
import com.example.projet_tutore_back.data.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageWS(
    @Autowired
    val messageService: MessageService
) {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/send")
    fun sendMessage(@RequestBody messageReq: MessageSendReqDto) : String {
        messageService.sendMessage(messageReq)
        return ""
    }
}
