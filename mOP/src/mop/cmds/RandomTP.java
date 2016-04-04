package mop.cmds;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.managers.ChatManager;

public class RandomTP implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			
			return true;
			
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("mop.randomtp") == false) {
			
			ChatManager.getInstance().messageNoPermission(p);
			
			return true;
		}
		
		int x, y, z;
		
		Random r = new Random();
		
		x = r.nextInt(5000);
		z = r.nextInt(5000);
		
		y = p.getWorld().getHighestBlockYAt(x, z);
		
		p.teleport(new Location(p.getWorld(), x, y, z));
		
		return true;
	}

}
