package com.example.projet_tutore_back.data.repository

import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository
import com.example.projet_tutore_back.data.entity.GroupChat
import com.example.projet_tutore_back.data.entity.GroupUser

@Repository
interface GroupChatRepository: CrudRepository<GroupChat, Long> {
    fun save(group: GroupChat) : GroupChat
    fun findGroupChatsByOwner(owner: GroupUser): List<GroupChat>
}
