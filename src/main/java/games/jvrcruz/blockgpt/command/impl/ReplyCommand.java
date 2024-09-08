package games.jvrcruz.blockgpt.command.impl;

import games.jvrcruz.blockgpt.BlockGPT;
import games.jvrcruz.blockgpt.util.Variables;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ReplyCommand implements CommandExecutor {
    private final BlockGPT main;

    public ReplyCommand(BlockGPT main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("blockgpt.ask")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /reply <message>");
                } else {
                    String message = String.join(" ", args);

                    String response = Variables.getGemini().getChatSession(player).sendPlayerMessage(message);

                    player.sendMessage(ChatColor.DARK_GREEN + response);
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
            return true;
        }
        return false;
    }
}
