package mop.mvaults.managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class VaultManager {
	
	public VaultManager() {

	}

	static VaultManager instance = new VaultManager();

	public static VaultManager getInstance() {
		return instance;
	}
		
	Plugin plugin;
	
	public void setup(Plugin p) {
		this.plugin = p;
		
		
	}
	public void setupPlayer(Player p) {
		
		File cfile = new File("plugins/mOP/mVaults/" + p.getName() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
		
		try {
			config.save(cfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void saveInventory(ItemStack[] inv, int inventory, String p) {
		
		File cfile = new File("plugins/mOP/mVaults/" + p + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
		
		ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
		
		for (ItemStack i : inv) {
			
			if (i == null) {
				i = new ItemStack(Material.AIR);
			}
			
			itemList.add(i);
			
		}
		
		config.set("inv." + inventory, itemList);
			
			try {
				config.save(cfile);
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		
	}
	
	public void saveInventory(ItemStack[] inv, int inventory, Player p) {
		
		File cfile = new File("plugins/mOP/mVaults/" + p.getName() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
		
		ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
		
		for (ItemStack i : inv) {
			
			if (i == null) {
				i = new ItemStack(Material.AIR);
			}
			
			itemList.add(i);
			
		}
		
		config.set("inv." + inventory, itemList);
			
			try {
				config.save(cfile);
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		
	}
	@SuppressWarnings("unchecked")
	public Inventory getInventory(int inventory, Player p) {
		
		
		File cfile = new File("plugins/mOP/mVaults/" + p.getName() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
		
		if (config.contains("inv." + inventory) == false) {
			
			ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
			
			config.set("inv." + inventory, itemList);
			
			try {
				config.save(cfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		Inventory inv;
		inv = Bukkit.getServer().createInventory(null, 27, ChatColor.RED + "Vault: " + p.getName() + " #" + inventory);
		
        ItemStack[] content = ((List<ItemStack>) config.get("inv." + inventory)).toArray(new ItemStack[0]);
        
        inv.setContents(content);
		
		
		return inv;
	}
	
	@SuppressWarnings("unchecked")
	public Inventory getInventory(int inventory, String p) {
		
		
		File cfile = new File("plugins/mOP/mVaults/" + p + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
		
		if (config.contains("inv." + inventory) == false) {
			
			ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
			
			config.set("inv." + inventory, itemList);
			
			try {
				config.save(cfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		Inventory inv;
		inv = Bukkit.getServer().createInventory(null, 27, ChatColor.RED + "Vault: " + p + " #" + inventory);
		
        ItemStack[] content = ((List<ItemStack>) config.get("inv." + inventory)).toArray(new ItemStack[0]);
        
        inv.setContents(content);
		
		
		return inv;
	}

}
