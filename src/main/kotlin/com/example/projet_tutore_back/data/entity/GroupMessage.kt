package com.example.projet_tutore_back.data.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
class GroupMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var grpMsgId: Long?,

    var senderId: String,

    @OneToOne
    var groupChat: GroupChat, // User or group Id

    // Varchar max length = 500
    var message: String,

    @CreationTimestamp
    var datetimeSent: Date?
)
