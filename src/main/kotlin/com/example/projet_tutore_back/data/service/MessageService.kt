package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService(
    @Autowired
    val messageRepository: MessageRepository
) {
    fun sendMessage(message: Message) {
        messageRepository.save(message)
    }
}
