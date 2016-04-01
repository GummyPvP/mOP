package mop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreprocess implements Listener {

	@EventHandler
	public void onCommandProcess(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().equalsIgnoreCase("/help")) {
			
			e.setCancelled(true);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m----------------------------------------------------"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                        &b&lHelp"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/tpa - Teleport to a player"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/tpaccept - Accept a telelport request"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/kit - Get a desired kit"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/warp - Warp to different locations"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/faction - View Factions help"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/vote - Vote to receive cool prizes"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/sethome - Save your homes"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/home - Telelport to your home"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/list - View the online players"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/home - Telelport to your home"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &a/help - view this page"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m----------------------------------------------------"));
			
			return;
		}
	}

}
