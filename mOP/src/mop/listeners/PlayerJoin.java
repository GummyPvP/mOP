package mop.listeners;

import meconomy.utils.mEcon;
import mop.managers.IPFilter;
import mop.managers.Manager;
import mop.managers.StatsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) { 
		Player p = e.getPlayer();
		
		mEcon econ = new mEcon(p);
		econ.setupPlayer();
		
		for (int i = 0; i < 150; i++) {
			p.sendMessage("        ");
		}
	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m-----------------------------------------------------"));
	  p.sendMessage("                                                          ");
	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                   &a&lWelcome to &b&lGummyPvP &a" + p.getDisplayName()   + "&a&l!"));
	  p.sendMessage("                                                          ");
	  p.sendMessage("                                                          ");
	  p.sendMessage("                                                          ");
	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                  &c&lFORUMS &fforums.gummypvp.com"));
	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                  &a&lSHOP &fstore.gummypvp.com"));
	  p.sendMessage("                                                          ");
	  p.sendMessage("                                                          ");
	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m-----------------------------------------------------"));
	  
		IPFilter.getInstance().setupPlayer(p);
	  
		if (StatsManager.getInstance().getConfig().get("users." + p.getName()) == null) {
			StatsManager.getInstance().getConfig()
					.set("users." + p.getName() + ".kills", 0);
			StatsManager.getInstance().getConfig()
					.set("users." + p.getName() + ".deaths", 0);
			StatsManager.getInstance().saveConfig();
			StatsManager.getInstance().reloadConfig();
		}
		Manager.getInstance().scoreboardRefresh(p);
		StatsManager.getInstance().getConfig()
				.set("users." + p.getName() + ".killstreak", 0);
	}

}
