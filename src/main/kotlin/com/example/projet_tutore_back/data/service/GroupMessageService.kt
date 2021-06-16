package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.GroupMessage
import com.example.projet_tutore_back.data.entity.Message
import com.example.projet_tutore_back.data.repository.GroupChatRepository
import com.example.projet_tutore_back.data.repository.GroupMessageRepository
import com.example.projet_tutore_back.websocket.service.WSCommunicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class GroupMessageService @Autowired constructor (
    val groupMessageRepository: GroupMessageRepository,
    val groupChatRepository: GroupChatRepository,
    val wsCommunicationService: WSCommunicationService
){
    fun sendMessageToGroup(messageReqDto: MessageSendReqDto) {
        if(messageReqDto.senderId != SecurityContextHolder.getContext().authentication.name.split('|')[1]) {
            // TODO: erreur
            return
        }
        val groupChat = groupChatRepository.findById(messageReqDto.groupId).get()
        groupMessageRepository.save(
            GroupMessage(
                null,
                messageReqDto.senderId,
                groupChat,
                messageReqDto.message,
                null
            )
        )
        for(user in groupChat.users) {
            wsCommunicationService.sendToUser(user.user, "/updateMessages", "test")
        }
    }
    fun getMessageInGroup(groupId: Long): List<GroupMessage> {
        return groupMessageRepository.findByGroupChat(groupChatRepository.findById(groupId).get())
    }
}
