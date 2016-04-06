package mop.listeners;

import mop.managers.MaintenanceManager;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {
	
	@EventHandler
	public void onServerPing(ServerListPingEvent e) {
		
		if (MaintenanceManager.getInstance().isEnabled() == true) {
			
			e.setMotd(ChatColor.translateAlternateColorCodes('&', 
					mop.managers.ConfigManager.getInstance().getConfig().getString("motd") +  
					      " \n " + 
							"             &a&l(!) &cCurrently down for maintenance &a&l(!)"));
			
		} else {
		
		e.setMotd(ChatColor.translateAlternateColorCodes('&', 
				mop.managers.ConfigManager.getInstance().getConfig().getString("motd") +  
				      " \n " + 
						"         &a&l(!) &b&lNow Open! Join Today! &a&l(!)"));
		
		}
	}
}