package mop.mspawn.cmds;

import java.util.ArrayList;

import mop.mspawn.utils.ConfigManager;
import mop.mspawn.utils.Manager;
import mop.mspawn.utils.SpawnManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
	
	public ArrayList<Player> teleporting = new ArrayList<Player>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			sender.sendMessage("Only players may use this command");
			return true;
			
		}
		
		final Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("Spawn")) {
			
			if (p.isOp() || p.hasPermission("spawn.instateleport")) {
				p.teleport(SpawnManager.getInstance().getSpawnLocation());
				return true;
			}
			
			Manager.getInstance().addPlayerToList(p);
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance().getConfig().getString("settings.teleportDelayMessage").replaceAll("<time>", ConfigManager.getInstance().getConfig().getString("settings.time"))));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(ConfigManager.getInstance().getPlugin(), new Runnable() {

				@Override
				public void run() {
					
					if (Manager.getInstance().listContainsPlayer(p)) {
						p.teleport(SpawnManager.getInstance().getSpawnLocation());
						Manager.getInstance().removePlayerFromList(p);
					}
					
				}
				
			}, ConfigManager.getInstance().getConfig().getInt("settings.time") * 20);			
		}
		
		return true;
		
	}

}
