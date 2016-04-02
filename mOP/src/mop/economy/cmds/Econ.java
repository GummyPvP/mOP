package mop.economy.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.economy.utils.Utils;
import mop.economy.utils.mEcon;

public class Econ implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("mecon")) {
			if (sender.hasPermission("mecon.mecon") == false) {
				sender.sendMessage(ChatColor.RED
						+ "I'm sorry, but you do not have permission to perform this command."
						+ " Please contact the server administrators if you believe that this is in error.");
				return true;
			}
			
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon balance <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon add <player> <amount>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon remove <player> <amount>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon set <player> <amount>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon reset <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer balance <player>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer add <player> <amount>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer remove <player> <amount>"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer set <player> <amount>"));
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("offlineplayer")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer add <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer remove <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer set <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer balance <player>"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("balance")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon balance <player>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("add")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon add <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("remove")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon remove <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("set")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon set <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("reset")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon reset <player>"));
					return true;
				}
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("offlineplayer")) {
					if (args[1].equals("add")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer add <player> <amount>"));
						return true;
					}
					if (args[1].equals("remove")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer remove <player> <amount>"));
						return true;
					}
					if (args[1].equals("set")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer set <player> <amount>"));
						return true;
					}
					if (args[1].equalsIgnoreCase("balance")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer balance <player>"));
						return true;
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("balance")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cTarget is offline!"));
						return true;
					}
					mEcon econ = new mEcon(target);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + target.getName() + ": " + ChatColor.AQUA + econ.getBalance()));
					return true;
				}
				if (args[0].equalsIgnoreCase("add")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon add <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("remove")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon remove <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("set")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon set <player> <amount>"));
					return true;
				}
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cTarget is offline!"));
						return true;
					}
					mEcon econ = new mEcon(target);
					econ.setBalance(0);;
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + target.getName() + " has been reset!"));
					return true;
				}
			}
			}
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("offlineplayer")) {
					if (args[1].equals("add")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer add <player> <amount>"));
						return true;
					}
					if (args[1].equalsIgnoreCase("remove")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer remove <player> <amount>"));
						return true;
					}
					if (args[1].equals("set")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer set <player> <amount>"));
						return true;
					}
					if (args[1].equalsIgnoreCase("balance")) {
				    		Player target = Bukkit.getServer().getPlayer(args[2]);
				    		
				    		if (target == null) {
				    		OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[2]);	
				    		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
				    				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + offline.getName() + "is: " + ChatColor.AQUA + mEcon.getInstance().getOfflinePlayerBalance(offline)));
				    			} else
				    			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &c " + offline.getName() + " has a insufficient balance to remove " + args[2]));
				    			
				    			return true;
				    		} else 
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cPlayer " + target.getName() + "is online!"));
				    		return true;
					
					}
				}
				if (args[0].equalsIgnoreCase("balance")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &c To many args!"));
					return true;
				}
				if (args[0].equalsIgnoreCase("add")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cTarget is offline!"));
						return true;
					}
					if (!Utils.isInt(args[2])) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cYou must supply a number!"));
						return true;
					}
					
					mEcon econ = new mEcon(target);
					econ.addMoney(Integer.parseInt(args[2]));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aPlayer " + target.getName() + " balance update!"));
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYour Balance is now: " + econ.getBalance()));
					
					
					return true;
				}
				if (args[0].equalsIgnoreCase("remove")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cTarget is offline!"));
						return true;
					}
					if (!Utils.isInt(args[2])) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cYou must supply a number!"));
						return true;
					}
					
					mEcon econ = new mEcon(target);
					if (econ.removeMoney(Integer.parseInt(args[2]))) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aPlayer " + target.getName() + " balance update!"));
					return true;
					} else 
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &c " + target.getName() + " has a insufficient balance to remove " + args[2]));
					
					return true;
				}
				
				if (args[0].equalsIgnoreCase("set")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cTarget is offline!"));
						return true;
					}
					if (!Utils.isInt(args[2])) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cYou must supply a number!"));
						return true;
					}
					
					mEcon econ = new mEcon(target);
					econ.setBalance(Integer.parseInt(args[2]));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aPlayer " + target.getName() + " balance update!"));
					return true;
				}
				if (args[0].equalsIgnoreCase("reset")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &c To many args!"));
					return true;
				} else
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon balance <player>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon add <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon remove <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon set <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon reset <player>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer add <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer remove <player> <amount>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &a/mecon offlineplayer set <player> <amount>"));
					return true;
					}
			if (args.length == 4) {
				if (args[0].equalsIgnoreCase("offlineplayer")) {
			    	if (args[1].equals("add")) {
			    		Player target = Bukkit.getServer().getPlayer(args[2]);
			    		
			    		if (target == null) {
			    		OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[2]);	
			    		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			    			mEcon.getInstance().addOfflinePlayerMoney(offline, Integer.parseInt(args[3]));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + offline.getName() + " has been updated!!"));
			    			
			    			return true;
			    		      }
			    		} else 
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cPlayer " + target.getName() + "is online!"));
					
					return true;
				}
			    	if (args[1].equals("remove")) {
			    		Player target = Bukkit.getServer().getPlayer(args[2]);
			    		
			    		if (target == null) {
			    		OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[2]);	
			    		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			    			if (mEcon.getInstance().removeMoneyOfflinePlayer(offline, Integer.parseInt(args[3]))) {
			    				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + offline.getName() + " has been updated!"));
			    			} else
			    			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &c " + offline.getName() + " has a insufficient balance to remove " + args[2]));
			    			
			    			return true;
			    		      }
			    		} else 
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cPlayer " + target.getName() + "is online!"));
					
					return true;
				
				}
				    if (args[1].equals("set")) {
			    		Player target = Bukkit.getServer().getPlayer(args[2]);
			    		
			    		if (target == null) {
			    		OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[2]);	
			    		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			    			mEcon.getInstance().setOfflinePlayerBalance(offline, Integer.parseInt(args[3]));
			    				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aBalance of " + offline.getName() + " has been updated!"));
			    						    			
			    			return true;
			    		      }
			    		} else 
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &cPlayer " + target.getName() + "is online!"));
					return true;
				}
				return true;
				}
			
			}
			return false;
	}

}
