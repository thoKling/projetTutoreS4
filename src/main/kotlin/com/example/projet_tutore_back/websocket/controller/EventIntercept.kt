package com.example.projet_tutore_back.websocket.controller

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.MessageHeaderAccessor


class EventIntercept: ChannelInterceptor {
    override fun postSend(message: Message<*>, channel: MessageChannel, sent: Boolean) {
        val accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor::class.java)
        val command = accessor!!.command
        if(command == StompCommand.CONNECT) {
            println("salut")
        }
        else if(command == StompCommand.DISCONNECT) {
            println("finito")
        }
    }
}
