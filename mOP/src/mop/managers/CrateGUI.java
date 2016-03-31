package mop.managers;

import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CrateGUI {
	
	Inventory inv;
	Player p;
	ItemStack uncommonkey;
	ItemStack commonkey;
	ItemStack rarekey;
	ItemStack glass;
	
	int uncommonkeyamount = 0;
	int commonkeyamount = 0;
	int rarekeyamount = 0;
	
	public void playerCrateAmounts() {
		
		for (ItemStack inv : p.getInventory().getContents()) {
			if (inv != null && inv.getType() != Material.AIR) {
		         if (inv.getItemMeta().hasDisplayName() == true) {
	               if (inv.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Common Crate Key")) {
	            	   commonkeyamount = commonkeyamount + inv.getAmount();
		
	         }
	       }
		}
	}
		for (ItemStack inv : p.getInventory().getContents()) {
			if (inv != null && inv.getType() != Material.AIR) {
		         if (inv.getItemMeta().hasDisplayName() == true) {
	               if (inv.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Uncommon Crate Key")) {
	            	   uncommonkeyamount = uncommonkeyamount + inv.getAmount();
		
	         }
	       }
		}
	}
		for (ItemStack inv : p.getInventory().getContents()) {
			if (inv != null && inv.getType() != Material.AIR) {
		         if (inv.getItemMeta().hasDisplayName() == true) {
	               if (inv.getItemMeta().getDisplayName().equals(ChatColor.RED + "Rare Crate Key")) {
	            	   rarekeyamount = rarekeyamount + inv.getAmount();
	         }
	       }
		}
	}
	}
	public CrateGUI(Player p) {
		this.p = p;
		
		inv = Bukkit.getServer().createInventory(null, 9 * 3 , ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP Crates"));
		
		playerCrateAmounts();
		
		commonkey = ItemManager.createItem(Material.TRIPWIRE_HOOK, 
				ChatColor.GREEN + "Common Crate Key", 
			Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&bYour inventory contains " + commonkeyamount + " Common Crate Key(s)!")));
		
		uncommonkey = ItemManager.createItem(Material.TRIPWIRE_HOOK, 
				ChatColor.GOLD + "Uncommon Crate Key", 
			Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&bYour inventory contains " + uncommonkeyamount + " Uncommon Crate Key(s)!")));
		
		rarekey = ItemManager.createItem(Material.TRIPWIRE_HOOK, 
				ChatColor.RED + "Rare Crate Key", 
			Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&bYour inventory contains " + rarekeyamount + " Rare Crate Key(s)!")));
		
		glass = ItemManager.createItem(Material.STAINED_GLASS_PANE, ChatColor.GREEN + "Crates");
		glass.setDurability((short) 7);
		
	for (int i = 0; i < 9; i++) {
			
			inv.setItem(i, glass);
			
		}
	for (int i = 17; i < 27; i++) {
		
		inv.setItem(i, glass);
		
	}
	inv.setItem(9, glass);
	inv.setItem(10, glass);
	inv.setItem(11, commonkey);
	inv.setItem(12, glass);
	inv.setItem(13, uncommonkey);
	inv.setItem(14, glass);
	inv.setItem(15, rarekey);
	inv.setItem(16, glass);
	
	}
	public void openInventory(Player p) {
		p.openInventory(inv);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP&8> &aOpening Crates GUI."));
	}
}
