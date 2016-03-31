package mop.listeners;

import mop.managers.JellyLegsManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityDamage implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if ((JellyLegsManager.getInstance().isJellyLegsEnabled(p)) && (e.getCause().equals(DamageCause.FALL))) {
			e.setCancelled(true);
		}
		
	}

}
