package games.jvrcruz.blockgpt.chat.impl;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AIRequest {

    private List<ChatMessage> messageContext = new ArrayList<>();

    public AIRequest(String message, @Nullable String systemInstruction) {
        if (systemInstruction != null) {
            SystemMessage systemMessage = SystemMessage.from(systemInstruction);
            messageContext.add(systemMessage);
        }

        UserMessage userMessage = UserMessage.from(message);
        messageContext.add(userMessage);
    }

    public List<ChatMessage> getMessage() {
        return messageContext;
    }

}
