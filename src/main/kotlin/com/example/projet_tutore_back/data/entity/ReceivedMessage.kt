package com.example.projet_tutore_back.data.entity

import javax.persistence.*

@Entity
class ReceivedMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var receivedMsgId: Long?,

    var receiverId: Long,

    @OneToOne
    @JoinColumn(name = "msgId")
    var msgId: Message
)
