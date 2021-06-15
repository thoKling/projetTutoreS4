package com.example.projet_tutore_back.data.service

import com.example.projet_tutore_back.data.entity.GroupChat
import com.example.projet_tutore_back.data.entity.GroupUser
import com.example.projet_tutore_back.data.repository.GroupChatRepository
import com.example.projet_tutore_back.data.repository.GroupUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class GroupService @Autowired constructor(
    val groupChatRepository: GroupChatRepository,
    val groupUserRepository: GroupUserRepository
) {
    fun createGroup(users: MutableList<String>) {
        val groupUsers = mutableListOf<GroupUser>()
        // Add group creator
        users.add(SecurityContextHolder.getContext().authentication.name.split('|')[1])
        for(user in users) {
            groupUsers.add(this.groupUserRepository.save(GroupUser(user)))
        }
        this.groupChatRepository.save(GroupChat(null, groupUsers, null))
    }

    fun retrieveGroups(user: String): MutableList<GroupChat> {
        val groupUser = this.groupUserRepository.findByUser(user)
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
}
