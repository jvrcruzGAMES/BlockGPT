package games.jvrcruz.blockgpt.chat.impl;


import dev.langchain4j.data.message.AiMessage;

public class AIResponse {

    private String response;

    public AIResponse(AiMessage response) {
        this.response = response.text();
    }

    public String getResponse() {
        return response;
    }

}
