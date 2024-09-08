package games.jvrcruz.blockgpt.command.impl;

import games.jvrcruz.blockgpt.BlockGPT;
import games.jvrcruz.blockgpt.chat.impl.AIChat;
import games.jvrcruz.blockgpt.util.Variables;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AskCommand implements CommandExecutor {

    private final BlockGPT main;

    public AskCommand(BlockGPT main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("blockgpt.ask")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /ask <message>");
                } else {
                    String message = String.join(" ", args);

                    AIChat chat = Variables.getGemini().createChatSession(player);

                    String response = chat.sendPlayerMessage(message);

                    player.sendMessage(ChatColor.DARK_GREEN + response);
                    player.sendMessage(ChatColor.DARK_GRAY + "To reply, use /reply <message>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
            return true;
        }

        return false;
    }
}
