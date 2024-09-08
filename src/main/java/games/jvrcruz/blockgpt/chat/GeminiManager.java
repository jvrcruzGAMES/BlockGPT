package games.jvrcruz.blockgpt.chat;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import games.jvrcruz.blockgpt.chat.impl.AIChat;
import games.jvrcruz.blockgpt.chat.impl.AIRequest;
import games.jvrcruz.blockgpt.chat.impl.AIResponse;
import games.jvrcruz.blockgpt.util.Variables;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GeminiManager {

    private final ChatLanguageModel gemini;
    private HashMap<Player, AIChat> chatSessions = new HashMap<>();

    public GeminiManager () {
        String APIKey = Variables.getConfigLoader().config.getString("Gemini.APIKey");

        if (APIKey == null) {
            throw new Error("API Key not found in config.yml");
        }
        if (APIKey.isEmpty()) {
            throw new Error("API Key not found in config.yml");
        }
        if (APIKey.equals("YOUR_API_KEY")) {
            throw new Error("API Key not found in config.yml");
        }

        gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(APIKey)
                .modelName("gemini-1.5-flash").build();

    }

    public AIChat getChatSession(Player player) {
        return chatSessions.get(player);
    }

    public AIChat createChatSession(Player player) {
        AIChat chat = new AIChat(gemini);

        chatSessions.put(player, chat);

        return chat;
    }

    public void removeChatSession(Player player) {
        chatSessions.remove(player);
    }

    protected AIResponse sendPluginMessage(AIRequest request) {

        ChatRequest chatRequest = ChatRequest.builder().messages(request.getMessage()).build();

        AiMessage aiMessage = gemini.chat(chatRequest).aiMessage();

        return new AIResponse(aiMessage);
    }
}
