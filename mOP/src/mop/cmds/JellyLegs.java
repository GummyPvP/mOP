package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.JellyLegsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JellyLegs implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("jellylegs")) {
			if (!sender.hasPermission("mop.jellylegs")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (JellyLegsManager.getInstance().isJellyLegsEnabled(p)) {
				JellyLegsManager.getInstance().setJellyLegs(p, false);
				p.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								"&8&l» &aJelly legs " + ChatColor.RED + "disabled!"));
				return true;
			} else {
				JellyLegsManager.getInstance().setJellyLegs(p, true);
				p.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								"&8&l» &aJelly legs " + ChatColor.AQUA + "enabled!"));
				return true;
			}
			
		}
		return false;
	}

}
