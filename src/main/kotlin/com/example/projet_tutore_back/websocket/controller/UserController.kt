package com.example.projet_tutore_back.websocket.controller

import org.springframework.stereotype.Controller

@Controller
class UserController {
    var connectedUsers = mutableMapOf<String?, String?>()
}
