package com.example.websocket.controller;

import com.example.websocket.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/chatrooms")
public class ChatController {


    @GetMapping(path = "/{id}")
    public String chatroom(Principal principal,  @PathVariable(name = "id") Long id, ModelMap modelMap){
        modelMap.addAttribute("chatRoomId", id);
        return "chat/chatroom";
    }

    //1. 로그인을 해서 로그인한 이름이 나올 수 있게
    //2. 1번방에서는 1번방끼리, 2번방에서는 2번방 사람끼리 채팅할 수 있게
    //3. HTTP에서 계속 연결될 수 있도록 하는 것이 Websocket이다.
}
