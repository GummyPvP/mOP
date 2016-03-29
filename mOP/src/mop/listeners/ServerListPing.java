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
					"       &b&m-&8»&e&m-&8»&b&m-&8»&e&m-&8» &8[&b✧&8] &b&lGummy PvP &8[&b✧&8] &8«&b&m-&8«&e&m-&8«&b&m-&8«&e&m-&r" + 
					      " \n " + 
							"         &a&l(!) &cCurrently down for maintenance &a&l(!)"));
			
		} else {
		
		e.setMotd(ChatColor.translateAlternateColorCodes('&', 
				"       &b&m-&8»&e&m-&8»&b&m-&8»&e&m-&8» &8[&b✧&8] &b&lGummy PvP &8[&b✧&8] &8«&b&m-&8«&e&m-&8«&b&m-&8«&e&m-&r" + 
				      " \n " + 
						"         &a&l(!) &b&lOP Factions! &b&lOpening Soon! &a&l(!)"));
		}
	}

}
