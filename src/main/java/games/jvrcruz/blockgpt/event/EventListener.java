package games.jvrcruz.blockgpt.event;

import games.jvrcruz.blockgpt.util.Variables;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Variables.getGemini().removeChatSession(e.getPlayer());
    }

}
