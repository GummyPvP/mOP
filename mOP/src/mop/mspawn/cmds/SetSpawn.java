package mop.mspawn.cmds;

import mop.mspawn.utils.ConfigManager;
import mop.mspawn.utils.SpawnManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			sender.sendMessage("Only players may use this command");
			return true;
			
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("SetSpawn")) {
			
			if (!p.hasPermission("spawn.set")) 
				return true;
			
			SpawnManager.getInstance().setSpawn(p.getLocation());
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance().getConfig().getString("settings.setSpawnMessage")));
		}
		
		return true;
		
	}

}
