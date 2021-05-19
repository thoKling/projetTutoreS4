package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class MessageService @Autowired constructor (
    val messageRepository: MessageRepository
) {
    fun sendMessageToUser(messageReqDto: MessageSendReqDto) {
        if(messageReqDto.senderId != SecurityContextHolder.getContext().authentication.name.split('|')[1]) {
            // TODO: erreur
            return
        }
        messageRepository.save(
            Message(
                null,
                messageReqDto.senderId,
                messageReqDto.receiverId,
                false,
                messageReqDto.message,
                null
            )
        )
    }
    fun getMessageWithUser(userId: String): List<Message> {
        // User id that sends the request
        val senderId = SecurityContextHolder.getContext().authentication.name.split('|')[1]
        val res = messageRepository.findAllBySenderIdAndReceiverIdAndGroupMessage(senderId, userId, false)
        val res2 = messageRepository.findAllBySenderIdAndReceiverIdAndGroupMessage(userId, senderId, false)
        return res + res2
    }
}
