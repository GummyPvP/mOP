package mop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import mop.managers.Manager;

public class EntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		
		Player p = (Player) e.getEntity();
		
		if ((Manager.getInstance().isJellyLegsEnabled(p)) && (e.getCause().equals(DamageCause.FALL))) {
			e.setCancelled(true);
		}
	}
}
