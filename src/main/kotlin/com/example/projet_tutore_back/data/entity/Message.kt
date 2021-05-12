package com.example.projet_tutore_back.data.entity

import javax.persistence.*

@Entity
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var msgId: Long?,

    var senderId: Long,

    // Varchar max length = 500
    var message: String
)
