package com.techcompare.backend.service;

import com.google.genai.Client;
import com.google.genai.errors.ServerException;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final Client client;
    private final String model;
    private final int maxAttempts;

    public GeminiService(
            @Value("${gemini.model}") String model,
            @Value("${gemini.max-attempts}") int maxAttempts) {

        this.client = Client.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .build();

        this.model = model;
        this.maxAttempts = maxAttempts;
    }

    public String askGemini(String prompt) {

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            try {
                GenerateContentResponse response =
                        client.models.generateContent(
                                model,
                                prompt,
                                null
                        );

                return response.text();

            } catch (ServerException exception) {

                if (attempt == maxAttempts) {
                    throw exception;
                }

                long delay =
                        (long) Math.pow(2, attempt - 1) * 1000;

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();

                    throw new RuntimeException(
                            "Gemini request was interrupted",
                            interruptedException
                    );
                }
            }
        }

        throw new RuntimeException("Gemini request failed");
    }
}