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
			
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &ahttp://gummypvp.com/vote"));
			
			sender.sendMessage(" ");
		}
		return true;
	}
}