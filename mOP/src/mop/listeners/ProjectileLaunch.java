package mop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import mop.managers.CombatManager;

public class ProjectileLaunch implements Listener {

	@EventHandler
	public void onPearlThrow(ProjectileLaunchEvent e) {
		
		if (e.getEntity() instanceof EnderPearl) {
			
			EnderPearl pearl = (EnderPearl) e.getEntity();
			
			if (pearl.getShooter() instanceof Player) {
				
				Player p = (Player) pearl.getShooter();
				
				if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.CREATIVE) return;
				if (p.hasPermission("mop.pearlcooldown.bypass")) return;
				
				if (CombatManager.getInstance().isInPearlTimer(p)) {
					
					e.setCancelled(true);
					p.getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() + 1);
					
					String second = CombatManager.getInstance().getPearlTime(p) == 1 ? "second" : "seconds";
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cYou can't throw your pearl for another " + CombatManager.getInstance().getPearlTime(p)
							+ " " + second + "!"));
					
				} else {
					
					CombatManager.getInstance().setPearlTimer(p, 10);
					
					CombatManager.getInstance().pearlDelay(p);
				}
			}
		}
	}
}
