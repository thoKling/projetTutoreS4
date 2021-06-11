package com.example.projet_tutore_back.websocket.interceptor

import com.example.projet_tutore_back.data.dto.UserStatusResDto
import com.example.projet_tutore_back.websocket.controller.UserController
import com.example.projet_tutore_back.websocket.service.WSCommunicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.MessageHeaderAccessor


class EventIntercept(
    private val userController: UserController,
    private val wsCommunicationService: WSCommunicationService
    ) : ChannelInterceptor {

    override fun postSend(message: Message<*>, channel: MessageChannel, sent: Boolean) {
        val accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor::class.java)
        val command = accessor!!.command
        val stompId = accessor.user?.name

        if(command == StompCommand.CONNECT) {
            val userId = accessor.getNativeHeader("login")?.first()
            userController.connectedUsers[userId] = stompId
            wsCommunicationService.sendToTopic("/updateStatus", UserStatusResDto(userId, "connected"));
        }
        else if(command == StompCommand.DISCONNECT) {
            userController.connectedUsers.values.remove(stompId)
        }
    }
}
