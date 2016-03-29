package mop.cmds;


import mop.managers.ChatManager;
import mop.managers.MaintenanceManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaintenanceMode implements CommandExecutor {
	
	
	MaintenanceManager mm = MaintenanceManager.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("maintenancemode")) {
		if (sender.hasPermission("mop.maintenancemode") == false) {
			ChatManager.getInstance().messageNoPermission(sender);
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &7Status: " + (mm.isEnabled() == true ? ChatColor.GREEN + "true" : ChatColor.RED + "false")));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " list"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " add <player>"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " remove <player>"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " toggle"));
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("list")) {
				StringBuilder sb = new StringBuilder();
				for (String players : mm.getWhitelistedPlayers()) {
					sb.append(players + ", ");
				}
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aThe Current Whitelisted Players are: &b" + sb.toString()));
				return true;
			}
			if (args[0].equalsIgnoreCase("add")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " add <player>"));
				return true;
			}
			if (args[0].equalsIgnoreCase("remove")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/" + arg2 + " remove <player>"));
				return true;
			}
			if (args[0].equalsIgnoreCase("toggle")) {
				if (mm.isEnabled() == true) {
					
					mm.toggleMaintenace(false);
					
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP&8&l» &aMaintenance Mode has been &cdisabled!"));
					
					return true;
				} else {
					
					
					mm.toggleMaintenace(true);
					
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP&8&l» &aMaintenance Mode has been &benabled!"));
					
					for (Player online : Bukkit.getServer().getOnlinePlayers()) {
						
						if (mm.isPlayerWhitelisted(online) == false) {
							
							online.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&b&lGummyPvP&8&l» &aThe server has current gone into &eMaintenance Mode&a. We will be back online soon!"));
							
						}
					
					}
					
					return true;
				}
				
			}
			
		}
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("list")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cToo many arguments!"));
				return true;
			}
			if (args[0].equalsIgnoreCase("add")) {
				if (mm.isPlayerWhitelisted(args[1]) == false) {
					mm.addPlayer(args[1]);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aPlayer has been added to the whitelist!"));
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aThis player is already whitelisted!"));
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("remove")) {
				if (mm.isPlayerWhitelisted(args[1]) == true) {
					mm.removePlayer(args[1]);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aPlayer has been removed from the whitelist!"));
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cThis player is not whitelisted!"));
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("toggle")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cToo many arguments!"));
				return true;
			}
			
		}
			return true;
		}
		return true;

	}

}
