package mop.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import mop.main.Main;
import mop.managers.ChatManager;
import net.md_5.bungee.api.ChatColor;

public class EntityDamageByEntity implements Listener {

	public static HashMap<String, Boolean> inCombat = new HashMap<String, Boolean>();
	public static HashMap<String, Long> combatTime = new HashMap<String, Long>();
	public static HashMap<String, BukkitRunnable> combatTimer = new HashMap<String, BukkitRunnable>();

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

			if (inCombat.containsKey(damaged.getName()) == false) {

				combatTime.remove(damaged.getName());
				combatTimer.remove(damaged.getName());

				inCombat.put(damaged.getName(), true);

				damaged.sendMessage(
						ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
								+ " &cYou are now in combat! Logging out will result in a penalty."));

				combatTime.put(damaged.getName(), System.currentTimeMillis());

				combatTimer.put(damaged.getName(), new BukkitRunnable() {

					@Override
					public void run() {

						inCombat.remove(damaged.getName());
						combatTime.remove(damaged.getName());
						combatTimer.remove(damaged.getName());

						damaged.sendMessage(
								ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
										+ " &aYou are no longer in combat! You may log out."));

					}
				});

				combatTimer.get(damaged.getName()).runTaskLater(Main.getPlugin(), 20 * 15);

			} else {

				if (inCombat.get(damaged.getName())) {

					if (combatTimer.containsKey(damaged.getName())) {

						combatTimer.get(damaged.getName()).cancel();
						combatTime.put(damaged.getName(), System.currentTimeMillis());

						combatTimer.put(damaged.getName(), new BukkitRunnable() {

							@Override
							public void run() {

								inCombat.remove(damaged.getName());
								combatTime.remove(damaged.getName());
								combatTimer.remove(damaged.getName());

								damaged.sendMessage(ChatColor.translateAlternateColorCodes('&',
										ChatManager.getInstance().getChatPrefix()
												+ " &aYou are no longer in combat! You may log out."));

							}
						});

						combatTimer.get(damaged.getName()).runTaskLater(Main.getPlugin(), 20 * 15);

					} else {

						damaged.kickPlayer(ChatColor.RED
								+ "An error has occured with CombatTag. Please report this to a staff member.");
						return;

					}

				}

			}

			//

			if (inCombat.containsKey(damager.getName()) == false) {

				combatTime.remove(damager.getName());
				combatTimer.remove(damager.getName());

				inCombat.put(damager.getName(), true);

				damager.sendMessage(
						ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
								+ " &cYou are now in combat! Logging out will result in a penalty."));

				combatTime.put(damager.getName(), System.currentTimeMillis());

				combatTimer.put(damager.getName(), new BukkitRunnable() {

					@Override
					public void run() {

						inCombat.remove(damager.getName());
						combatTime.remove(damager.getName());
						combatTimer.remove(damager.getName());

						damager.sendMessage(
								ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
										+ " &aYou are no longer in combat! You may log out."));

					}
				});

				combatTimer.get(damager.getName()).runTaskLater(Main.getPlugin(), 20 * 15);

			} else {

				if (inCombat.get(damager.getName())) {

					if (combatTimer.containsKey(damager.getName())) {

						combatTimer.get(damager.getName()).cancel();
						
						combatTime.put(damager.getName(), System.currentTimeMillis());

						combatTimer.put(damager.getName(), new BukkitRunnable() {

							@Override
							public void run() {

								inCombat.remove(damager.getName());
								combatTime.remove(damager.getName());
								combatTimer.remove(damager.getName());

								damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
										ChatManager.getInstance().getChatPrefix()
												+ " &aYou are no longer in combat! You may log out."));

							}
						});

						combatTimer.get(damager.getName()).runTaskLater(Main.getPlugin(), 20 * 15);

					} else {

						damager.kickPlayer(ChatColor.RED
								+ "An error has occured with CombatTag. Please report this to a staff member.");
						return;

					}

				}

			}

		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();

		if (inCombat.containsKey(p.getName())) {

			p.setHealth(0);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					ChatManager.getInstance().getChatPrefix() + " &c" + p.getName() + " logged out of combat!"));
		}

	}
}