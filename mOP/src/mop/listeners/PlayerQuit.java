package mop.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		//Player p = e.getPlayer();
//		if (CombatManager.getInstance().containsPlayer(p)) {
//			CombatManager.getInstance().removePlayer(p);
//			for (ItemStack item : p.getInventory().getContents()) {
//				if (item != null) {
//					p.getLocation()
//							.clone()
//							.getWorld()
//							.dropItemNaturally(p.getLocation().clone(),
//									item.clone());
//				}
//			}
	//		p.setHealth(0.0);
	//		p.getInventory().clear();
	//		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
	//				"&8&l» &c" + p.getName() + " logged out in combat!"));
		}
}