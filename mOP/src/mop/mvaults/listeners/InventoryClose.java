package mop.mvaults.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import mop.mvaults.managers.VaultManager;

public class InventoryClose implements Listener {
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		
		String inv_name = e.getInventory().getName();
		
		if (inv_name.contains("Vault") == true) {
			
			//String oldString = null;
			
//			Pattern pattern = Pattern.compile("/[#]+[0-9]/");
//		
//			Matcher m = pattern.matcher(inv_name);
//		
//			while (m.find()) {
//				
//				oldString = m.group(1);
//			
//			}
		
			//String inv_number = oldString.replaceAll("/#/", "");
		
			String[] each_string = inv_name.split(" ");
			
			String inventory_num = each_string[2].replace("#", "");
		
			ItemStack[] items = e.getInventory().getContents();
		
			VaultManager.getInstance().saveInventory(items, Integer.parseInt(inventory_num), each_string[1]);
		
		}
	}

}
