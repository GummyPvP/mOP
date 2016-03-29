package mop.cmds;


import mop.managers.ChatManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveItem implements CommandExecutor {
	  private boolean isInt(String s, Player p)
	  {
	    try {
	      Integer.parseInt(s);
	      return true; 
	      } catch (NumberFormatException e) {
	    }
	    return false;
	  }
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Console cannot get items!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("giveitem")) {
			if (!sender.hasPermission("mop.give")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " <item> <amount> <itemmeta>" ));
				return true;
			}
			if (args.length == 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " <item> <amount> <itemmeta>" ));
				return true;
			}
			if (args.length == 2) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " <item> <amount> <itemmeta>" ));
				return true;
			}
				try {
					if (isInt(args[1], p)) {	
						if (args[2].equalsIgnoreCase("null")) {
							Material m = Material.getMaterial(args[0].toUpperCase());
							ItemStack itemstack = new ItemStack(m, Integer.parseInt(args[1]));
							p.getInventory().addItem(itemstack);
						     p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aAdded " + args[1] + " " + args[0] + " to " + p.getDisplayName() + "'s Inventory!"));
						     p.updateInventory();
						     return true;
						} else {
						Material m = Material.getMaterial(args[0].toUpperCase());
						ItemStack itemstack = new ItemStack(m, Integer.parseInt(args[1]));
						ItemMeta ism = itemstack.getItemMeta();
						ism.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[2]));
						itemstack.setItemMeta(ism);
						p.getInventory().addItem(itemstack);
						 p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aAdded " + args[1] + " " + args[0] + " to " + p.getDisplayName() + "'s Inventory!"));
					     p.updateInventory();
						 return true;
						}
						} else 
							
						     p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cPlease specify a amount to give!"));
						return true;
				} catch (Exception e) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cPlease specify a item to give!"));
					return true;
		}
		}
		return false;
		
	}
}
