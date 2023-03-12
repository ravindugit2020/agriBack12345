package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    // mapped to handle chat messages to the /sendmsg destination
    @MessageMapping("/sendmsg")
    // the return value is broadcast to all subscribers of /chat/messages
    @SendTo("/chat/messages")
    public ChatMessage chat(ChatMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new ChatMessage(message.getText(), message.getUsername(), message.getAvatar());
    }
}
