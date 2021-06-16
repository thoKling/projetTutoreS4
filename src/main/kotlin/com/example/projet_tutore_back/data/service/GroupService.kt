package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.entity.GroupChat
import com.example.projet_tutore_back.data.entity.GroupUser
import com.example.projet_tutore_back.data.repository.GroupChatRepository
import com.example.projet_tutore_back.data.repository.GroupUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class GroupService @Autowired constructor(
    val groupChatRepository: GroupChatRepository,
    val groupUserRepository: GroupUserRepository
) {
    fun createGroup(users: MutableList<String>) {
        val groupUsers = mutableListOf<GroupUser>()
        for(user in users) {
            groupUsers.add(this.groupUserRepository.save(GroupUser(user)))
        }
        // Add group creator
        val creatorId = SecurityContextHolder.getContext().authentication.name.split('|')[1]
        val creator = this.groupUserRepository.save(GroupUser(creatorId))
        groupUsers.add(creator)

        this.groupChatRepository.save(GroupChat(null, creator, groupUsers, null))
    }

    fun findOrSaveGroupUser(user: String): GroupUser {
        return try {
            this.groupUserRepository.findByUser(user)
        } catch (e: EmptyResultDataAccessException) {
            groupUserRepository.save(GroupUser(user))
        }
    }

    fun retrieveGroups(user: String): MutableList<GroupChat> {
        val groupUser: GroupUser = findOrSaveGroupUser(user)
        val groupChats = this.groupChatRepository.findAll()

        val res = mutableListOf<GroupChat>()
        for (groupChat in groupChats) {
            if(groupChat.users.contains(groupUser)) {
                res.add(groupChat)
            }
        }
        return res
    }
    fun getGroup(groupId: Long): GroupChat {
        return groupChatRepository.findById(groupId).get()
    }
    fun removeFromGroup(groupId: Long, userId: String) {
        val group = getGroup(groupId)
        val user = findOrSaveGroupUser(userId)
        group.users.remove(user)
        groupChatRepository.save(group)
    }
    fun addToGroup(groupId: Long, userId: String) {
        val group = getGroup(groupId)
        val user = findOrSaveGroupUser(userId)
        group.users.add(user)
        groupChatRepository.save(group)
    }
}
