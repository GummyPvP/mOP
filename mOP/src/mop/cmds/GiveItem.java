package mop.cmds;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mop.managers.ChatManager;

public class GiveItem implements CommandExecutor {
	private boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
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
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &a/" + arg2 + " <item> <amount> <itemmeta>"));
				return true;
			}
			if (args.length == 1) {
				
				try {
					
					if (isInt(args[0]) == true) {
						
						Material m = Material.getMaterial(Integer.parseInt(args[0].toUpperCase()));
						
						ItemStack item = new ItemStack(m, 64);
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));
						
					} else {
						
						Material m = Material.getMaterial(args[0].toUpperCase());
						
						ItemStack item = new ItemStack(m, 64);
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));	
					}
					
					
				} catch (Exception e) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cThat item is not valid."));
				}
				
				
			}
			if (args.length == 2) {
				
				if (isInt(args[1]) == false) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cThat is not a number!"));
					
					return true;
				}
				
				try {
					
					if (isInt(args[0]) == true) {
						
						Material m = Material.getMaterial(Integer.parseInt(args[0].toUpperCase()));
						
						ItemStack item = new ItemStack(m, Integer.parseInt(args[1]));
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));
						
					} else {
						
						Material m = Material.getMaterial(args[0].toUpperCase());
						
						ItemStack item = new ItemStack(m, Integer.parseInt(args[1]));
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));	
					}
					
					
				} catch (Exception e) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cThat item is not valid."));
				}
			}
			if (args.length == 3) {
				
				if (isInt(args[1]) == false) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cThat is not a number!"));
					
					return true;
				}
				
				try {
					
					if (isInt(args[0]) == true) {
						
						Material m = Material.getMaterial(Integer.parseInt(args[0].toUpperCase()));
						
						ItemStack item = new ItemStack(m, Integer.parseInt(args[1]));
						
						ItemMeta im = item.getItemMeta();
						
				        String name = StringUtils.join(args, ' ', 2, args.length);
						
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
						
						item.setItemMeta(im);
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));
						
					} else {
						
						Material m = Material.getMaterial(args[0].toUpperCase());
						
						ItemStack item = new ItemStack(m, Integer.parseInt(args[1]));
						
						ItemMeta im = item.getItemMeta();
						
				        String name = StringUtils.join(args, ' ', 2, args.length);
						
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
						
						item.setItemMeta(im);
						
						p.getInventory().addItem(item);
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &aItem has been added to your inventory"));	
					}
					
					
				} catch (Exception e) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cThat item is not valid."));
				}
			}
		}
		return true;
	}
}