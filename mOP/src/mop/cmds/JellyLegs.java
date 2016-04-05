package mop.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.managers.ChatManager;
import mop.managers.Manager;

public class JellyLegs implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("jellylegs")) {
			if (!sender.hasPermission("mop.jellylegs")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (Manager.getInstance().isJellyLegsEnabled(p)) {
				Manager.getInstance().setJellyLegsEnabled(p, false);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &aJelly legs " + ChatColor.RED + "disabled!"));
				return true;
			} else {
				Manager.getInstance().setJellyLegsEnabled(p, true);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &aJelly legs " + ChatColor.AQUA + "enabled!"));
				return true;
			}
		}
		return true;
	}
}