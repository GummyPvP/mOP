package mop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import mop.managers.ChatManager;
import mop.managers.CombatManager;
import mop.mspawn.utils.SpawnManager;

public class EntityDamageByEntity implements Listener {

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {

		Entity ent = e.getEntity();
		Entity ente = e.getDamager();

		if (ent instanceof Player && ente instanceof Player) {

			final Player damaged = (Player) ent;
			final Player damager = (Player) ente;

			final double oldHealth = damaged.getHealth();
			final double newHealth = oldHealth - e.getDamage();

			if (oldHealth == newHealth)
				return;

			if (e.getDamage() == 0)
				return;

			if (e.isCancelled())
				return;
			
			if (mgeneral.utilites.Manager.getInstance().checkVanishEnabled(damaged) || mgeneral.utilites.Manager.getInstance().checkVanishEnabled(damager)) return;
			
			if (SpawnManager.getInstance().getSpawnLocation().getWorld() == damaged.getLocation().getWorld()) {
				
				if (SpawnManager.getInstance().getSpawnLocation().distance(damaged.getLocation()) <= 17) return;
				
			}
			
			if (SpawnManager.getInstance().getSpawnLocation().getWorld() == damager.getLocation().getWorld()) {
				
				if (SpawnManager.getInstance().getSpawnLocation().distance(damager.getLocation()) <= 17) return;
				
			}
			
			if (CombatManager.getInstance().isInCombat(damaged) == false) {
				
				if (damaged.getAllowFlight() == true) {
					
					damaged.setAllowFlight(false);
					
				}
				
				damaged.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &cYou are now in combat. Do not log out."));

			}
				
			if (CombatManager.getInstance().isInCombat(damager) == false) {
				
				if (damager.getAllowFlight() == true) {
					
					damager.setAllowFlight(false);
					
				}
				
				damager.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &cYou are now in combat. Do not log out."));
				
			}
			
			CombatManager.getInstance().forceCombatRemove(damager);
			CombatManager.getInstance().setInCombat(damager, true);
			CombatManager.getInstance().startCombatTimer(damager);
			
			CombatManager.getInstance().forceCombatRemove(damaged);
			CombatManager.getInstance().setInCombat(damaged, true);
			CombatManager.getInstance().startCombatTimer(damaged);
			
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();

		if (CombatManager.getInstance().isInCombat(p)) {

			p.setHealth(0);
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &c" + p.getName() + " logged out of combat!"));
		}
	}
}