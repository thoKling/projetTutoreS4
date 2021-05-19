package com.example.projet_tutore_back.websocket.config

import com.example.projet_tutore_back.websocket.controller.EventIntercept
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.ChannelRegistration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker
class WebSocketBrokerConfig : WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.setApplicationDestinationPrefixes("/app")
        config.setUserDestinationPrefix("/user")
    }

    override fun registerStompEndpoints(config: StompEndpointRegistry) {
        config.addEndpoint("/ws")
            .setAllowedOriginPatterns("*")
            //.setHandshakeHandler(UserHandshakeHandler())
            .withSockJS()
    }

    override fun configureClientInboundChannel(registration: ChannelRegistration) {
        registration.interceptors(EventIntercept())
    }
}
