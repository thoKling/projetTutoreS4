package com.example.projet_tutore_back.data.repository

import com.example.projet_tutore_back.data.entity.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CrudRepository<Message, Int> {
    fun save(message: Message) : Message
}
