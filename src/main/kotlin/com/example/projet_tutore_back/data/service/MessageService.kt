package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.entity.ReceivedMessage
import com.example.projet_tutore_back.data.repository.MessageRepository
import com.example.projet_tutore_back.data.repository.ReceivedMessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService @Autowired constructor (
    val messageRepository: MessageRepository,
    val receivedMessageRepository: ReceivedMessageRepository
) {
    fun sendMessage(messageReqDto: MessageSendReqDto) {
        val persistedMessage = messageRepository.save(
            Message(
                null,
                messageReqDto.senderId,
                messageReqDto.message)
        )
        receivedMessageRepository.save(
            ReceivedMessage(
                null,
                messageReqDto.receiverId,
                persistedMessage
            )
        )
    }
}
