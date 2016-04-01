package mop.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.economy.api.mEconAPI;
import mop.managers.ChatManager;

public class Pay implements CommandExecutor {

	private boolean isInt(String s, Player p) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cPlease specify a amount to pay!"));
		}
		return true;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pay")) {
			if (!sender.hasPermission("mop.pay")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/pay <player> <amount>"));
				return true;
			}
			if (args.length == 2) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &cPlayer " + args[0] + " &cis offline!"));
					return true;
				}
				if (target.getName().equals(p.getName())) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cYou cannot pay yourself!"));
					return true;
				}
				if (isInt(args[1], p)) {
					if (args[1].equalsIgnoreCase("0")) {
						sender.sendMessage(ChatColor.RED + "You cannot send $0!");
						return true;
					}
					if (mEconAPI.removeMoney(p, Integer.parseInt(args[1]))) {
						mEconAPI.addMoney(target, Integer.parseInt(args[1]));
						target.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &a Received $" + args[1] + " from " + p.getName()));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&l» &a Giving $" + args[1] + " to " + target.getName()));
						return true;
					} else
						sender.sendMessage(
								ChatColor.translateAlternateColorCodes('&', "&8&l» &cYou do not have enough money!"));
					return true;
				}
			} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &a/pay <player> <amount>"));
		}
		return true;
	}

}
