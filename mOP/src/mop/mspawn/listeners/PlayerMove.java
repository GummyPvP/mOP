package mop.mspawn.listeners;

import mop.mspawn.utils.ConfigManager;
import mop.mspawn.utils.Manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
        if (e.getFrom().getBlockX() == e.getTo().getBlockX() && e.getFrom().getBlockY() == e.getTo().getBlockY() && e.getFrom().getBlockZ() == e.getTo().getBlockZ()) return;
        
        Player p = e.getPlayer();
        
        if (Manager.getInstance().listContainsPlayer(p)) {
        	
        	Manager.getInstance().removePlayerFromList(p);
        	
        	p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance().getConfig().getString("settings.teleportDeniedMessage")));
        	
        } else return;
		
	}
	
	

}
