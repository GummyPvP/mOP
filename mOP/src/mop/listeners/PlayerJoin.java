package mop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import mop.economy.utils.mEcon;
import mop.managers.IPFilter;
import mop.managers.Manager;
import mop.managers.StatsManager;
import mop.mvaults.managers.VaultManager;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();

		mEcon econ = new mEcon(p);
		econ.setupPlayer();
		
		VaultManager.getInstance().setupPlayer(p);
		
		String[] message = new String[] { "&b&m-----------------------------------------------------",
										  "                                                          ",
										  "                   &a&lWelcome to &b&lGummyPvP &a" + p.getDisplayName() + "&a&l!",
										  "                                                          ",
										  "                                                          ",
										  "                  &c&lFORUMS &fforums.gummypvp.com",
										  "                  &a&lSHOP &fstore.gummypvp.com",
                                          "                                                          ",
                                          "                  &8[&a+&8] &7Want to see new changes? Try /changelog",
										  "                                                          ",
										  "&b&m-----------------------------------------------------"
		
		};
		

		for (int i = 0; i < 150; i++) {
			p.sendMessage(" ");
		}
		
		
		for (String msg : message) {
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			
		}

		IPFilter.getInstance().setupPlayer(p);

		if (StatsManager.getInstance().getConfig().get("users." + p.getName()) == null) {
			StatsManager.getInstance().getConfig().set("users." + p.getName() + ".kills", 0);
			StatsManager.getInstance().getConfig().set("users." + p.getName() + ".deaths", 0);
			StatsManager.getInstance().saveConfig();
			StatsManager.getInstance().reloadConfig();
		}
		
		Manager.getInstance().scoreboardRefresh(p);
		StatsManager.getInstance().getConfig().set("users." + p.getName() + ".killstreak", 0);
	}
}