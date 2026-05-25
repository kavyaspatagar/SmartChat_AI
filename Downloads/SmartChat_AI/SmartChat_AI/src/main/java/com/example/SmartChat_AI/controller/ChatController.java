package com.example.SmartChat_AI.controller;

import com.example.SmartChat_AI.model.ChatRequest;
import com.example.SmartChat_AI.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody ChatRequest request) {

        String reply = aiService.getResponse(request.getMessage());

        Map<String, String> response = new HashMap<>();

        response.put("reply", reply);

        return response;
    }
}