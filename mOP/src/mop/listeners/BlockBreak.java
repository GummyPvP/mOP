package mop.listeners;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mop.managers.ChatManager;
import mop.managers.Utils;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if (p.getGameMode() == GameMode.CREATIVE) return;
		
		if (b.getType() == Material.SLIME_BLOCK) {
			
			e.setCancelled(true);
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cThis block can only be broken with tnt!"));
			return;
		}
		
		if (b.getType() == Material.MOB_SPAWNER) {
			
			CreatureSpawner spawner = (CreatureSpawner) b.getState();
			
			if (p.getItemInHand().hasItemMeta() == false) return;
			
			if (p.getItemInHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH) == false) return;
			
			if (Utils.inventoryIsEmpty(p.getInventory())) {
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &cYour inventory is full, please have a slot open for the spawner!"));
				
				e.setCancelled(true);
				return;
			}
			
			String type = spawner.getSpawnedType().name();
			
			String spawnerName = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
			
			e.setCancelled(true);
			
			b.setType(Material.AIR);
			
			ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
			
			ItemMeta spawnerIM = spawnerItem.getItemMeta();
			
			spawnerIM.setDisplayName(ChatColor.GREEN + spawnerName + " Spawner");
			spawnerIM.setLore(Arrays.asList("This is a " + spawnerName + " Spawner!", "Place it where you want mobs to spawn"));
			
			spawnerItem.setItemMeta(spawnerIM);
			
			p.getInventory().addItem(spawnerItem);
			
			return;
		}
		
	}
}
