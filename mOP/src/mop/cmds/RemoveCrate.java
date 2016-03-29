package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.ConfigManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCrate implements CommandExecutor {
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			return true;
		}
		Player p = (Player) sender;
		
		if (sender.hasPermission("mop.removecrate") == false) {
			
			ChatManager.getInstance().messageNoPermission(sender);
			
			return true;
		}
		String location = p.getLocation().getWorld().getName() + ":" + p.getLocation().getBlockX() + ":" + p.getLocation().getBlockY() + ":" + p.getLocation().getBlockZ();
		if (ConfigManager.getInstance().checkLocation(location) == true) {
			ConfigManager.getInstance().getCratesConfig().getList("crates").remove(location);
			ConfigManager.getInstance().saveCratesConfig();
			p.sendMessage(ChatColor.GREEN + "Crate has been removed!");
			return true;
		} else sender.sendMessage(ChatColor.RED + "There is no crate in that location!");
		return true;
 	}

}
