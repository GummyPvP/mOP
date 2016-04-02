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
			
			if (CombatManager.getInstance().isInCombat(damaged)) {
				
				CombatManager.getInstance().forceCombatRemove(damaged);
				
			}
			
			if (CombatManager.getInstance().isInCombat(damager)) {
				
				CombatManager.getInstance().forceCombatRemove(damager);
				
			}
			
			CombatManager.getInstance().startCombatTimer(damaged);
			CombatManager.getInstance().startCombatTimer(damager);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();

		if (CombatManager.getInstance().isInCombat(p)) {

			p.setHealth(0);
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					ChatManager.getInstance().getChatPrefix() + " &c" + p.getName() + " logged out of combat!"));
		}
	}
}