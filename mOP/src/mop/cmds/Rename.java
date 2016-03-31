package mop.cmds;

import mop.managers.Manager;
import mpermissions.utils.ChatManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rename implements CommandExecutor {
	
	
    @SuppressWarnings("static-access")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rename")) {
			if (!sender.hasPermission("mop.rename")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (p.getItemInHand() == null) {
				sender.sendMessage(ChatColor.RED + "You must be holding a item!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Invalid ussage! Please use /rename <Name>");
				return true;
			}
			if (args.length == 1) {
			Manager.getInstance().setName(p,(Manager.getInstance().Args(0,args)));
			return true;
			}
			}
		return false;
	}

}
