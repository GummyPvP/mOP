package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.Manager;
import mop.managers.StatsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("reload")) {
			if (sender.hasPermission("mstats.reload")) {
				Bukkit.broadcastMessage(ChatColor.RED
						+ "Due to a server reload, your current killstreak has been set to 0!");
				Bukkit.reload();
				for (Player online : Bukkit.getOnlinePlayers()) {
					StatsManager.getInstance().getConfig()
							.set("users." + online.getName(), 0);
					StatsManager.getInstance().saveConfig();
					StatsManager.getInstance().reloadConfig();
					Manager.getInstance().scoreboardRefresh(online);
				}

				Bukkit.broadcastMessage(ChatColor.GREEN
						+ "Server successfully reloaded!");
			} else
				ChatManager.getInstance().messageNoPermission(sender);
		}

		return true;
	}

}
