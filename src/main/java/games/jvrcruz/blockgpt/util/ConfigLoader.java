package games.jvrcruz.blockgpt.util;

import games.jvrcruz.blockgpt.BlockGPT;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigLoader {

    private final BlockGPT main;
    public FileConfiguration config;

    public ConfigLoader(BlockGPT main) {
        this.main = main;
        this.config = main.getConfig();
    }

    public FileConfiguration loadConfig() {
        config = main.getConfig();
        return config;
    }
}
