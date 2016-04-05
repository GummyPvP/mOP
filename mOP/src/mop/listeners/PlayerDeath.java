package mop.listeners;

import mop.managers.CombatManager;
import mop.managers.StatsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	int oldKS;

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Entity ent = e.getEntity();
		e.setDeathMessage(null);
		if (ent instanceof Player) {
			
			Player p = (Player) ent;
			
			this.oldKS = Integer.valueOf(StatsManager.getInstance().getConfig().getInt("users." + p.getName() + ".killstreak"));
			
			if (p.getKiller() instanceof Player) {
				StatsManager
						.getInstance()
						.getConfig()
						.set("users." + p.getKiller().getName() + ".kills",
								Integer.valueOf(StatsManager
										.getInstance()
										.getConfig()
										.getInt("users."
												+ p.getKiller().getName()
												+ ".kills") + 1));
				StatsManager
						.getInstance()
						.getConfig()
						.set("users." + p.getKiller().getName() + ".killstreak",
								Integer.valueOf(StatsManager
										.getInstance()
										.getConfig()
										.getInt("users."
												+ p.getKiller().getName()
												+ ".killstreak") + 1));
				
				StatsManager.getInstance().saveConfig();
				StatsManager.getInstance().reloadConfig();

				StatsManager
						.getInstance()
						.getConfig()
						.set("users." + p.getName() + ".deaths",
								Integer.valueOf(StatsManager
										.getInstance()
										.getConfig()
										.getInt("users." + p.getName()
												+ ".deaths") + 1));
				StatsManager.getInstance().getConfig()
						.set("users." + p.getName() + ".killstreak", 0);
				StatsManager.getInstance().saveConfig();
				StatsManager.getInstance().reloadConfig();
				
				//Manager.getInstance().scoreboardRefresh(p.getKiller());
				//Manager.getInstance().scoreboardRefresh(p);

				int killerKS = Integer.valueOf(StatsManager
						.getInstance()
						.getConfig()
						.getInt("users." + p.getKiller().getName()
								+ ".killstreak"));
				if (killerKS != 0 && killerKS % 5 == 0) {
					Bukkit.broadcastMessage(ChatColor
							.translateAlternateColorCodes('&',
									"&b&lGummyPvP&8> &b Whoa! &6&l"
											+ p.getKiller().getName()
											+ " &b&lis on a &6&l" + killerKS
											+ " &b&lkillstreak!"));
				}

				if (oldKS != 0 && oldKS % 5 == 0) {
					Bukkit.broadcastMessage(ChatColor
							.translateAlternateColorCodes('&',
									"&b&lGummyPvP&8> &b Watch out! &6&l"
											+ p.getName()
											+ " &b&llost their &6&l" + oldKS
											+ " &b&lkillstreak to &6&l "
											+ p.getKiller().getName() + "&b&l!"));
				}

				if (p.getKiller().getItemInHand().hasItemMeta()
						&& p.getKiller().getItemInHand().getItemMeta()
								.hasDisplayName()) {
					e.setDeathMessage(ChatColor.translateAlternateColorCodes(
							'&', "&c"
									+ p.getName()
									+ " &7was slain by &c"
									+ p.getKiller().getName()
									+ " &7with &c"
									+ p.getKiller().getItemInHand()
											.getItemMeta().getDisplayName()));
				} else {
					e.setDeathMessage(ChatColor.translateAlternateColorCodes(
							'&', "&c"
									+ p.getName()
									+ " &7was slain by &c"
									+ p.getKiller().getName()
									+ " &7with a &c"
									+ p.getKiller().getItemInHand().getType()
											.toString().toLowerCase()
											.replaceAll("_", " ")));
				}
				
				killerKS = 0;
				oldKS = 0;

				if (CombatManager.getInstance().isInCombat(p)) 
					CombatManager.getInstance().forceCombatRemove(p);
			} else
				return;
		} else
			return;
	}
}
