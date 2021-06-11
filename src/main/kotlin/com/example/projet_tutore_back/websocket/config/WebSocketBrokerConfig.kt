package com.example.projet_tutore_back.websocket.config

import com.example.projet_tutore_back.websocket.controller.UserController
import com.example.projet_tutore_back.websocket.interceptor.EventIntercept
import com.example.projet_tutore_back.websocket.interceptor.UserHandshakeHandler
import com.example.projet_tutore_back.websocket.service.WSCommunicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.ChannelRegistration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker
class WebSocketBrokerConfig @Autowired constructor(
    val userController : UserController,
    val wsCommunicationService: WSCommunicationService
) : WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.setApplicationDestinationPrefixes("/app")
        config.setUserDestinationPrefix("/user")
    }

    override fun registerStompEndpoints(config: StompEndpointRegistry) {
        config.addEndpoint("/ws")
            .setAllowedOriginPatterns("*")
            .setHandshakeHandler(UserHandshakeHandler())
            .withSockJS()
    }

    override fun configureClientInboundChannel(registration: ChannelRegistration) {
        registration.interceptors(EventIntercept(userController, wsCommunicationService))
    }
}
