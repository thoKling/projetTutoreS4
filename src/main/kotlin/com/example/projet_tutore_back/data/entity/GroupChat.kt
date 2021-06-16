package com.example.projet_tutore_back.data.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
class GroupChat(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var grpId: Long?,

    @OneToOne
    var owner: GroupUser,

    @ManyToMany
    var users: MutableList<GroupUser>,

    @CreationTimestamp
    var creationTime: Date?
)
