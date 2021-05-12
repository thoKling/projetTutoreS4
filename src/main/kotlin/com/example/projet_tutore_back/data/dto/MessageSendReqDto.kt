package com.example.projet_tutore_back.data.dto

data class MessageSendReqDto (
    val senderId: Long,
    val receiverId: Long,
    val message: String
)

