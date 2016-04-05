package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.KeyType;
import mop.managers.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveKey implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("givekey")) {
			if (sender.hasPermission("mop.givekey")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							"&8&l» &cPlease use /givekey <player> <keytype>"));
					return true;
				}

				if (args.length == 1) {
					if (sender instanceof Player) {
						if (args[0].equalsIgnoreCase("common")
								|| args[0].equalsIgnoreCase("uncommon")
								|| args[0].equalsIgnoreCase("rare")) {
							Manager.getInstance().giveKey((Player) sender,
									KeyType.valueOf(args[0].toUpperCase()));
							sender.sendMessage(ChatColor
									.translateAlternateColorCodes('&',
											"&8&l» &aGiven key to player."));
						} else
							sender.sendMessage(ChatColor
									.translateAlternateColorCodes('&',
											"&8&l» &cPlease use /givekey COMMON | UNCOMMON | RARE"));
					} else
						ChatManager.getInstance().messageSenderPlayerOnly(
								sender);
				}

				if (args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					if (target == null) {
						sender.sendMessage(ChatColor
								.translateAlternateColorCodes('&',
										"&8&l» &cPlayer is not online."));
						return true;
					}
					if (args[1].equalsIgnoreCase("common")
							|| args[1].equalsIgnoreCase("uncommon")
							|| args[1].equalsIgnoreCase("rare")) {
						Manager.getInstance().giveKey(target,
								KeyType.valueOf(args[1].toUpperCase()));
						sender.sendMessage(ChatColor
								.translateAlternateColorCodes('&',
										"&8&l» &aGiven key to player."));
					} else
						sender.sendMessage(ChatColor
								.translateAlternateColorCodes('&',
										"&8&l» &cPlease use /givekey COMMON|UNCOMMON|RARE"));
				}

				if (args.length > 2) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							"&8&l» &cPlease use /givekey <player> <keytype>"));
					return true;
				}

			} else
				ChatManager.getInstance().messageNoPermission(sender);
		}
		return true;
	}

}
