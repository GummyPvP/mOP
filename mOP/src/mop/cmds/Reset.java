package mop.cmds;

import meconomy.api.mEconAPI;
import mop.managers.ChatManager;
import mop.managers.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reset implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("reset")) {
			if (args.length == 0) {
				Player p = (Player) sender;
				int balance = mEconAPI.getMoney(p);
				int bal = 2000000 - balance;
				if (mEconAPI.removeMoney(p, bal)) {
					p.sendMessage(ChatColor.GREEN
							+ "Success! Your stats have been reset.");
					Manager.getInstance().resetStats(p);
					Manager.getInstance().scoreboardRefresh(p);
				} else
					p.sendMessage(ChatColor.RED + "You must have "
							+ ChatColor.GOLD + bal + ChatColor.RED
							+ " more dollars to reset your stats!");
				return true;
			}

			if (!sender.hasPermission("mstats.reset")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}

			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.RED + "Invalid player!");
			} else {
				Manager.getInstance().resetStats(target);
				sender.sendMessage(ChatColor.GREEN + target.getName()
						+ "'s stats were reset!");
				target.sendMessage(ChatColor.GREEN + "Your stats were reset!");
				Manager.getInstance().scoreboardRefresh(target);
			}

		}
		return true;
	}

}
