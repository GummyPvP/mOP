package mop.cmds;

import mop.managers.ChatManager;
import mop.managers.ConfigManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Createcrate implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			return true;
		}
		Player p = (Player) sender;

		if (sender.hasPermission("mop.createcrate") == false) {

			ChatManager.getInstance().messageNoPermission(sender);

			return true;
		}
		String location = p.getLocation().getWorld().getName() + ":" + p.getLocation().getBlockX() + ":" + p.getLocation().getBlockY() + ":" + p.getLocation().getBlockZ();
		ConfigManager.getInstance().addLocation(location);
		p.getLocation().getBlock().setType(Material.CHEST);
		p.sendMessage(ChatColor.GREEN + "Crate has been created!");
		return true;
	}

}
