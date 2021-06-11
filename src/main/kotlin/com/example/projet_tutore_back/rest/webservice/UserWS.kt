package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.UserStatusResDto
import com.example.projet_tutore_back.websocket.controller.UserController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserWS @Autowired constructor(
    val userController: UserController
){
    @GetMapping("/status")
    fun status(): MutableList<UserStatusResDto> {
        val res : MutableList<UserStatusResDto> = mutableListOf()
        for (connectedUser in this.userController.connectedUsers) {
            res.add(UserStatusResDto(connectedUser.key, "connected"))
        }
        return res
    }
}
