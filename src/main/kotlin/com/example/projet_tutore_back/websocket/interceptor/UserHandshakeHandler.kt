package com.example.projet_tutore_back.websocket.interceptor

import com.example.projet_tutore_back.websocket.data.StompPrincipal
import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.DefaultHandshakeHandler
import java.security.Principal

class UserHandshakeHandler : DefaultHandshakeHandler() {
    override fun determineUser(
        request: ServerHttpRequest,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Principal {
        // generate user name by UUID
        return StompPrincipal("6")
    }
}
