package com.example.projet_tutore_back.data.repository

import com.example.projet_tutore_back.data.entity.ReceivedMessage
import org.springframework.data.repository.CrudRepository

interface ReceivedMessageRepository : CrudRepository<ReceivedMessage, Long> {
    fun save(receivedMessage: ReceivedMessage) : ReceivedMessage
}
