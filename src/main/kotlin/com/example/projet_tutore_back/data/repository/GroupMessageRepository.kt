package com.example.projet_tutore_back.data.repository

import com.example.projet_tutore_back.data.entity.GroupChat
import com.example.projet_tutore_back.data.entity.GroupMessage
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupMessageRepository : CrudRepository<GroupMessage, Long> {
    fun save(message: GroupMessage) : GroupMessage
    fun findByGroupChat(groupChat: GroupChat) : List<GroupMessage>
}
