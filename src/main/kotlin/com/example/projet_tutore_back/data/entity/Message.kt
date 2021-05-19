package com.example.projet_tutore_back.data.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var msgId: Long?,

    var senderId: String,

    var receiverId: String, // User or group Id

    var groupMessage: Boolean,

    // Varchar max length = 500
    var message: String,

    @CreationTimestamp
    var datetimeSended: Date?
)
