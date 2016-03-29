package mop.managers;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager 
{
	public static ItemStack createItem(Material m, String name,
			List<String> lore) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

	public static void createItem(Material m, String name, List<String> lore,
			Inventory inv) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		im.setLore(lore);
		is.setItemMeta(im);
		inv.addItem(is);
	}

	public static void createItem(Material m, String name, List<String> lore,
			Inventory inv, int slot) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		im.setLore(lore);
		is.setItemMeta(im);
		inv.setItem(slot, is);
	}

	public static ItemStack createItem(Material m, String s) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', s));
		is.setItemMeta(im);
		return is;
	}
}
