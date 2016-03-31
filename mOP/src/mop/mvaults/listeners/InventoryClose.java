package mop.mvaults.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mop.mvault.managers.VaultManager;

public class InventoryClose implements Listener {
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		
		
		String inv_name = e.getInventory().getName();
		
		
		if (inv_name.contains("Vault") == true) {
		
		String inv_number = inv_name.replaceAll("\\D+","");
		
		ItemStack[] items = e.getInventory().getContents();
		
		VaultManager.getInstance().saveInventory(items, Integer.parseInt(inv_number), p);
		
		}
	}

}
