package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.IPFilter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Ip implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender.hasPermission("mop.ip") == false) {
			ChatManager.getInstance().messageNoPermission(sender);
			return true;
		}
		if (args.length == 0) {
		
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip enable <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip disable <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip setip <player> <ip>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip logs <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip status <player>"));
		
			return true;
		}
		if (args.length == 1) {
			
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip enable <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip disable <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip setip <player> <ip>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip logs <player>"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip status <player>"));
		
			return true;
		}
		if (args.length == 2) {
			
			if (args[0].equalsIgnoreCase("enable")) {
				
				
				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
				
				IPFilter.getInstance().setStatus(args[1], true);
				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aPlayer " + args[1] + " ip filter has been &benabled!"));
				
				} else 	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cPlayer " + args[1] + " has never joined the server!"));
				
			} else if (args[0].equalsIgnoreCase("disable")) {
				
				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
					
				IPFilter.getInstance().setStatus(args[1], false);
				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aPlayer " + args[1] + " ip filter has been &cdisabled!!"));
				
				} else 	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cPlayer " + args[1] + " has never joined the server!"));
				
			} else if (args[0].equalsIgnoreCase("setip")) {
				
				
				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip setip <player>"));
					
				} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c Player " + args[1] + " has never joined the server!"));
				
				
			} else if (args[0].equalsIgnoreCase("logs")) {
				
				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
					
				    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&l----------------------------------"));
				    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&c Ip logs for " + args[1] + " are the following:"));
				    for (String ip : IPFilter.getInstance().getLogs(args[1]))
				    	sender.sendMessage(ChatColor.RED + ip);
				    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&l----------------------------------"));
					
				} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c Player " + args[1] + " has never joined the server!"));

				
			} else if (args[0].equalsIgnoreCase("status")) {

				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
				
				if (IPFilter.getInstance().getStatus(args[1]) == false) {
					
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bIP Filter for &e" + args[1] + " &bis currently: &cDisabed"));
					
				} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bIP Filter for &e" + args[1] + " &bis currently: &aEnabled"));
				} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c Player " + args[1] + " has never joined the server!"));
		 } else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip enable <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip disable <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip setip <player> <ip>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip logs <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/ip status <player>"));
			}
			return true;
		}
		if (args.length == 3) {
                 if (args[0].equalsIgnoreCase("setip")) {
				
				
				if (IPFilter.getInstance().getConfig().contains("filter." + args[1]) == true) {
					
					IPFilter.getInstance().setIP(args[1], args[2]);
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aIP for " + args[1] + " updated!"));
					
				} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c Player " + args[1] + " has never joined the server!"));
               }
                 return true;
		}
		return false;
	}
}
