package com.example.projet_tutore_back.websocket.data

import java.security.Principal

/**
 * Custom Principal class which is used for anonymous user sessions in Websocket connection
 */
class StompPrincipal(private val name: String) : Principal {
    override fun getName(): String {
        return name
    }
}
