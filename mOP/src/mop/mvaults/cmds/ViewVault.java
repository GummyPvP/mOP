package mop.mvaults.cmds;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import mop.managers.ChatManager;
import mop.managers.Utils;
import mop.mvaults.managers.VaultManager;
import net.md_5.bungee.api.ChatColor;

public class ViewVault implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		
		if (!(sender instanceof Player)) {
			
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			
			return true;
			
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("viewvault")) {
			if (sender.hasPermission("mvault.viewvault") == false) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
		}
		
		if (args.length == 0) {
			
			sender.sendMessage(ChatColor.RED + "/viewvault <player> <number>");

			return true;
		}
		if (args.length == 1) {
			sender.sendMessage(ChatColor.RED + "/viewvault <player> <number>");
			return true;
		}
		if (args.length == 2) {
			
			if (Utils.isInt(args[1]) == false) {
				
				sender.sendMessage(ChatColor.RED + "Please specify a number!");
				
				return true;
				
			}
			
			String name = args[0];
			
			int number = Integer.parseInt(args[1]);
			
			File cfile = new File("plugins/mOP/mVaults/" + name + ".yml");
			FileConfiguration config = YamlConfiguration.loadConfiguration(cfile);
			
			if (cfile.exists() == false) {
				
				sender.sendMessage(ChatColor.RED + "That playe has never joined the server!");
				
				return true;
			}
			if (config.contains("inv." + number) == false) {
				
				sender.sendMessage(ChatColor.RED + "That player does not have vault number " + number + " !");
				
				return true;
				
			}
			
			Inventory inv = VaultManager.getInstance().getInventory(number, name);
			
			p.openInventory(inv);
			
			return true;
			
		}
		
		return true;
	}

}
