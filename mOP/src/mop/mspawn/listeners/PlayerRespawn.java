package mop.mspawn.listeners;

import mop.mspawn.utils.SpawnManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {
	
	
	
	@EventHandler
	public void onReSpawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
				
				p.teleport(SpawnManager.getInstance().getSpawnLocation());

	}

}
