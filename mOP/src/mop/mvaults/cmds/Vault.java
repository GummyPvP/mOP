package mop.mvaults.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import mop.managers.ChatManager;
import mop.managers.Utils;
import mop.mvaults.managers.VaultManager;
import net.md_5.bungee.api.ChatColor;

public class Vault implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		
		if (!(sender instanceof Player)) {
			
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			
			return true;
			
		}
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("vault")) {
			
			if (sender.hasPermission("mvaults.vault") == false) {
				
				ChatManager.getInstance().messageNoPermission(sender);
				
				return true;
				
			}
		}
		if (args.length == 0) {
			
			sender.sendMessage(ChatColor.RED + "Please use /pv <number>");
			
			return true;
		}
		if (Utils.isInt(args[0]) == false) {
			
			sender.sendMessage(ChatColor.RED + "You must specify a number!");
			
		  return true;
		
		}
		if (p.hasPermission("vault." + args[0]) == false) {
			
			sender.sendMessage(ChatColor.RED + "You do not have permission for vault " + args[0]);
			
			return true;
		}
		
		Inventory inv = VaultManager.getInstance().getInventory(Integer.parseInt(args[0]), p);
		
		
		sender.sendMessage(ChatColor.GREEN + "Opening Vault " + args[0]);
		
		p.openInventory(inv);
		return true;
	}

}
