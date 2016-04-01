package mop.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Vote implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("Vote")) {
			sender.sendMessage(" ");
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aVote at these fine websites to get rewards!"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttp://minecraft-server-list.com/server/344316/vote/"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttp://www.planetminecraft.com/server/gummymc/vote/"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttps://www.minestatus.net/144708-gummymc"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttp://minecraftservers.org/server/340826"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttp://topg.org/Minecraft/in-429803"));
			
			sender.sendMessage(" ");
		}
		return true;
	}
}