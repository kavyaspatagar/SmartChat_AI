package com.example.SmartChat_AI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AiService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public AiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getResponse(String userMessage) {

        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Please enter a message.";
        }

        String url = "https://api.groq.com/openai/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        // ✅ Messages list (SYSTEM + USER)
        List<Map<String, String>> messages = new ArrayList<>();

        // 🔥 Jenny personality (IMPORTANT FIX)
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put(
                "content",
                "You are an AI assistant named Jenny. " +
                        "If the user asks 'who are you', reply: 'I am Jenny, your personal AI assistant.' " +
                        "You are friendly, helpful, and concise."
        );

        messages.add(systemMessage);

        // user message
        Map<String, String> user = new HashMap<>();
        user.put("role", "user");
        user.put("content", userMessage);

        messages.add(user);

        // request body
        Map<String, Object> body = new HashMap<>();
        body.put("model", "llama-3.3-70b-versatile");
        body.put("messages", messages);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            Map responseBody = response.getBody();

            if (responseBody == null || !responseBody.containsKey("choices")) {
                return "Invalid response from AI server.";
            }

            List choices = (List) responseBody.get("choices");

            if (choices == null || choices.isEmpty()) {
                return "No response from AI.";
            }

            Map choice = (Map) choices.get(0);
            Map message = (Map) choice.get("message");

            return message.get("content").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "AI server error: " + e.getMessage();
        }
    }
}