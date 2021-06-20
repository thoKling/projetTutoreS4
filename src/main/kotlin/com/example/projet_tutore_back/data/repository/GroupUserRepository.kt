package com.example.projet_tutore_back.data.repository

import com.example.projet_tutore_back.data.entity.GroupUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupUserRepository: CrudRepository<GroupUser, Long> {
    fun save(groupToUser: GroupUser) : GroupUser
    fun findByUser(user: String): GroupUser
}
