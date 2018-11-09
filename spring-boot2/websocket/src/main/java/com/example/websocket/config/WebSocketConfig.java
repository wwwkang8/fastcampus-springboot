package com.example.websocket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 조건
        /*원하는 메서드 오버라이드하기*/

        // websocket 접속경로 : /ws
        // sockjs를 지원하도록 한다.

        //socketHandler는 브로커이다. SocketHandler가 제일 중요
        registry.addHandler(new SocketHandler(), "/ws").withSockJS();
    }
}
