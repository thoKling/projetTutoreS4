package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/message")
class MessageWS(
    @Autowired
    val messageService: MessageService
) {
    @PostMapping("/send")
    fun sendMessage(@RequestBody messageReq: MessageSendReqDto) {
        messageService.sendMessageToUser(messageReq)
    }
    @GetMapping("/chatWithUser/{userId}")
    fun getChatWithUser(@PathVariable userId: String): List<Message> {
        return messageService.getMessageWithUser(userId)
    }
}
