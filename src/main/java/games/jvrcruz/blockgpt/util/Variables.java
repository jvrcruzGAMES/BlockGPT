package games.jvrcruz.blockgpt.util;

import games.jvrcruz.blockgpt.BlockGPT;
import games.jvrcruz.blockgpt.chat.GeminiManager;

public class Variables {

    private static GeminiManager gemini;
    private static ConfigLoader configLoader;
    private static BlockGPT main;

    public static GeminiManager getGemini() {
        return gemini;
    }

    public static void setGemini(GeminiManager gemini) {
        Variables.gemini = gemini;
    }

    public static ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public static void setConfigLoader(ConfigLoader configLoader) {
        Variables.configLoader = configLoader;
    }

    public static BlockGPT getMain() {
        return main;
    }

    public static void setMain(BlockGPT main) {
        Variables.main = main;
    }
}
