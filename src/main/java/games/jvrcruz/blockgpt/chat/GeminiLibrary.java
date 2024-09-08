package games.jvrcruz.blockgpt.chat;

import games.jvrcruz.blockgpt.chat.impl.AIRequest;
import games.jvrcruz.blockgpt.chat.impl.AIResponse;

import javax.annotation.Nullable;

public class GeminiLibrary {

    private GeminiManager gemini;

    public GeminiLibrary(GeminiManager gemini) {
        this.gemini = gemini;
    }

    public AIResponse sendPluginAIRequest(AIRequest request) {
        return gemini.sendPluginMessage(request);
    }

    public AIResponse sendPluginAIRequest(String query, @Nullable String systemInstruction) {
        AIRequest request = new AIRequest(query, systemInstruction);

        return gemini.sendPluginMessage(request);
    }

    public AIResponse sendPluginAIRequest(String query) {
        return sendPluginAIRequest(query, null);
    }



}
