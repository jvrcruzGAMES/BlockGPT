package games.jvrcruz.blockgpt;

import games.jvrcruz.blockgpt.chat.GeminiManager;
import games.jvrcruz.blockgpt.command.impl.AskCommand;
import games.jvrcruz.blockgpt.command.impl.ReplyCommand;
import games.jvrcruz.blockgpt.event.EventListener;
import games.jvrcruz.blockgpt.util.ConfigLoader;
import games.jvrcruz.blockgpt.chat.GeminiLibrary;
import games.jvrcruz.blockgpt.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockGPT extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            getConfig().options().copyDefaults();
            saveDefaultConfig();

            Variables.setConfigLoader(new ConfigLoader(this));
            Variables.setGemini(new GeminiManager());
            Variables.setMain(this);

            Bukkit.getPluginManager().registerEvents(new EventListener(), this);

            getCommand("ask").setExecutor(new AskCommand(this));
            getCommand("reply").setExecutor(new ReplyCommand(this));

            System.out.println("[BLOCKGPT] Plugin initialized successfully.");
        } catch (Exception e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println("[BLOCKGPT] " + stackTraceElement.toString());
            }
            System.out.println("[BLOCKGPT] Failed to initialize the plugin. Aborting...");
        }
    }

    @Override
    public void onDisable() {
        System.out.println("[BLOCKGPT] Plugin disabled.");
    }

    public GeminiLibrary getGeminiAPI() {
        return new GeminiLibrary(Variables.getGemini());
    }
}
