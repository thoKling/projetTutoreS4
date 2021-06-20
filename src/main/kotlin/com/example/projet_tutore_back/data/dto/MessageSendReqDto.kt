package com.example.projet_tutore_back.data.dto

data class MessageSendReqDto (
    val senderId: String,
    val groupId: Long,
    val message: String
)

