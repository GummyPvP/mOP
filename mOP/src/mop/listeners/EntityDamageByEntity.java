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

import mop.main.Main;
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

				CombatManager.getInstance().setInCombat(damaged, true);

				damaged.sendMessage(
						ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
								+ " &cYou are now in combat! Logging out will result in a penalty."));

				CombatManager.getInstance().setRunnable(damaged, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

					@Override
					public void run() {
						
						if (CombatManager.getInstance().getDelayTime(damaged) <= 0) {
							
							CombatManager.getInstance().forceCombatRemove(damaged);

							damaged.sendMessage(
									ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
											+ " &aYou are no longer in combat! You may log out."));
							
							Bukkit.getScheduler().cancelTask(CombatManager.getInstance().getRunnable(damaged));
							
						} else CombatManager.getInstance().setDelayTime(damaged, (CombatManager.getInstance().getDelayTime(damaged) - 1));
						
					}
					
				}, 0L, 20L));
				
			}

			//

			if (CombatManager.getInstance().isInCombat(damager)) {
				
				CombatManager.getInstance().forceCombatRemove(damager);

				CombatManager.getInstance().setInCombat(damager, true);

				damager.sendMessage(
						ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
								+ " &cYou are now in combat! Logging out will result in a penalty."));
				
				CombatManager.getInstance().setRunnable(damaged, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

					@Override
					public void run() {
						
						if (CombatManager.getInstance().getDelayTime(damager) <= 0) {
							
							CombatManager.getInstance().forceCombatRemove(damager);

							damager.sendMessage(
									ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
											+ " &aYou are no longer in combat! You may log out."));
							
							Bukkit.getScheduler().cancelTask(CombatManager.getInstance().getRunnable(damager));
							
						} else CombatManager.getInstance().setDelayTime(damaged, (CombatManager.getInstance().getDelayTime(damager) - 1));
						
					}
					
				}, 0L, 20L));
		}
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