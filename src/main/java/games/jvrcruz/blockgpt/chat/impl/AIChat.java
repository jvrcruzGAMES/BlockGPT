package games.jvrcruz.blockgpt.chat.impl;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;

import java.util.ArrayList;
import java.util.List;

public class AIChat {

    private List<ChatMessage> messages = new ArrayList<>();
    private final ChatLanguageModel model;


    public AIChat(ChatLanguageModel model) {
        this.model = model;
    }

    public String sendPlayerMessage(String message) {
        UserMessage userMessage = UserMessage.from(message);
        messages.add(userMessage);

        ChatRequest request = ChatRequest.builder().messages(messages).build();
        ChatResponse response = model.chat(request);

        AiMessage aiMessage = response.aiMessage();
        messages.add(aiMessage);

        return aiMessage.text();
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
