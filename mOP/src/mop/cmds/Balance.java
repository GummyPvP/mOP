package mop.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.economy.api.mEconAPI;
import mop.managers.ChatManager;

public class Balance implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("balance")) {
			if (!sender.hasPermission("mop.balance")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aBalance: &b$" + ChatColor.AQUA + mEconAPI.getMoney(p)));
			return true;
		}
		return false;
	}

}
