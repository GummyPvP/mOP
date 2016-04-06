package mop.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import net.md_5.bungee.api.ChatColor;

public class BlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {

		Block block = e.getBlock();
		
		if (block.getType() == Material.MOB_SPAWNER) {
			
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			
			if (e.getItemInHand().hasItemMeta() == false) return;
			if (e.getItemInHand().getItemMeta().hasDisplayName() == false) return;
			if (e.getItemInHand().getItemMeta().hasLore() == false) return;
			
			String type = ChatColor.stripColor(e.getItemInHand().getItemMeta().getDisplayName().split("_")[0].toUpperCase());
			
			EntityType entityType;
			
			try {
				
				entityType = EntityType.valueOf(type);
				spawner.setSpawnedType(entityType);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
