package mop.listeners;

import mop.managers.IPFilter;
import mop.managers.MaintenanceManager;
import mop.managers.Manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {

		Player p = e.getPlayer();
		String ip = e.getAddress().getHostAddress();

		if (MaintenanceManager.getInstance().isEnabled() == true) {
			if (MaintenanceManager.getInstance().isPlayerWhitelisted(p.getName()) == false) {
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&',
						" &b&lGummyPvP&8> &aWe are currently down for maintenance, we will be back online soon!"));
				return;
			}
		}

		if (IPFilter.getInstance().getConfig().contains("filter." + p.getName()) == true) {

			if (IPFilter.getInstance().getStatus(p) == true) {
				if (IPFilter.getInstance().getIP(p).equals(ip) == false) {
					e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&',
							"               &8&l>>  &4You are trying to login as a admin. Staff have been notified. &8&l<<"));
					Manager.getInstance().adminMessage(ChatColor.translateAlternateColorCodes('&',
							"&c&m-----------------------------------------------------"));
					Manager.getInstance().adminMessage(ChatColor.translateAlternateColorCodes('&',
							"&c A Player has tried to login as " + p.getName()));
					Manager.getInstance().adminMessage(
							ChatColor.translateAlternateColorCodes('&', "&c The suspect's ip is [" + ip + "]"));
					Manager.getInstance().adminMessage(ChatColor.translateAlternateColorCodes('&',
							"&c&m-----------------------------------------------------"));
					IPFilter.getInstance().log(p, ip);
					return;
				}
			}
		}
	}

}
