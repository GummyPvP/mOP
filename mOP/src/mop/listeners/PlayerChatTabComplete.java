package mop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class PlayerChatTabComplete implements Listener {
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerChatTab(PlayerChatTabCompleteEvent e) {
		
		 Bukkit.broadcastMessage("HI");
		
	}

}
