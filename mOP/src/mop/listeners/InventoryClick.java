package mop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

	int uncommonkeyamount = 0;
	int commonkeyamount = 0;
	int rarekeyamount = 0;
	int legendarykeyamount = 0;

	public void playerCrateAmounts(Player p) {

		uncommonkeyamount = 0;
		commonkeyamount = 0;
		rarekeyamount = 0;
		legendarykeyamount = 0;

		for (ItemStack inv : p.getInventory().getContents()) {
			if (inv != null && inv.getType() != Material.AIR) {
		         if (inv.getItemMeta().hasDisplayName() == true) {
	               if (inv.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Legendary Crate Key")) {
	            	   legendarykeyamount = legendarykeyamount + inv.getAmount();
		
	         }
	       }
		}
	}
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

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			playerCrateAmounts(p);
			if (!inv.getName().equals(ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP Crates")))
				return;

			if (e.getCurrentItem() == null)
				return;

			if (e.getCurrentItem().getType() == Material.AIR)
				return;

			if (e.getCurrentItem().getItemMeta().getDisplayName() == null)
				return;

			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Crates")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Legendary Crate Key")) {

				e.setCancelled(true);
				p.closeInventory();
				
				if (legendarykeyamount == 0) {
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &cYour inventory does not contain any &5Legendary Crate Key(s)&c!"));
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &bClick on the crate with your &5Legendary Crate Key(s)&b!"));
				}
				
				
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Common Crate Key")) {
				e.setCancelled(true);
				p.closeInventory();

				if (commonkeyamount == 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &cYour inventory does not contain any &aCommon Crate Key(s)&c!"));
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &bClick on the crate with your &aCommon Crate Key(s)&b!"));
				}
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Uncommon Crate Key")) {
				e.setCancelled(true);
				p.closeInventory();

				if (uncommonkeyamount == 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &cYour inventory does not contain any &6Uncommon Crate Key(s)&c!"));
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &bClick on the crate with your &6Uncommon Crate Key(s)&b!"));
				}
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Rare Crate Key")) {
				e.setCancelled(true);
				p.closeInventory();
				if (rarekeyamount == 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &cYour inventory does not contain any &cRare Crate Key(s)&c!"));
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b&lGummyPvP&8> &bClick on the crate with your &cRare Crate Key(s)&b!"));
				}
				return;
			}

		}
	}
}
