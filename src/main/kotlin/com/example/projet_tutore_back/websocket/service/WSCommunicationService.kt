package com.example.projet_tutore_back.websocket.service

import com.example.projet_tutore_back.websocket.controller.UserController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Service

@Service
class WSCommunicationService {
    @Autowired
    lateinit var messagingTemplate: SimpMessageSendingOperations

    @Autowired
    lateinit var userController: UserController

    fun sendToUser(userId: String, topic: String, obj: Any) {
        userController.connectedUsers[userId]?.let { messagingTemplate.convertAndSendToUser("6", topic, obj) }
    }
}
