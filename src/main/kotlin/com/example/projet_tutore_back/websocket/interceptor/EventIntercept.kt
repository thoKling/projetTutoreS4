package com.example.projet_tutore_back.websocket.interceptor

import com.example.projet_tutore_back.websocket.controller.UserController
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.MessageHeaderAccessor


class EventIntercept(private val userController: UserController) : ChannelInterceptor {

    override fun postSend(message: Message<*>, channel: MessageChannel, sent: Boolean) {
        val accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor::class.java)
        val command = accessor!!.command
        if(command == StompCommand.CONNECT) {
            userController.connectedUsers[accessor.getNativeHeader("login")?.first()] = accessor.user?.name
        }
        else if(command == StompCommand.DISCONNECT) {
            userController.connectedUsers.values.remove(accessor.user?.name)
        }
    }
}
