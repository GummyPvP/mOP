package mop.tutorial.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.managers.ChatManager;
import mop.tutorial.utils.TutorialManager;

public class SetTutorialPoint implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			
			return true;
		}
		
		Player p = (Player) sender;
		int amount = 0;
		
		if (p.hasPermission("mop.tutorial.set") == false) {
			
			ChatManager.getInstance().messageNoPermission(p);
			
			return true;
		}
		
		if (TutorialManager.getTutorialFile().contains("points") == false) {
			
			TutorialManager.getTutorialFile().set("points.1.location.x", p.getLocation().getBlockX());
			TutorialManager.getTutorialFile().set("points.1.location.y", p.getLocation().getBlockY());
			TutorialManager.getTutorialFile().set("points.1.location.z", p.getLocation().getBlockZ());
			TutorialManager.getTutorialFile().set("points.1.location.yaw", p.getLocation().getYaw());
			TutorialManager.getTutorialFile().set("points.1.location.pitch", p.getLocation().getPitch());
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &aSet tutorial point #1!"));
			return true;
		}
		
		for (int i = 0; i < TutorialManager.getTutorialFile().getSection("points").getKeys(false).size(); i++) {
			
			amount++;
			
		}
		
		amount++;
		
		TutorialManager.getTutorialFile().set("points." + amount + ".location.x", p.getLocation().getBlockX());
		TutorialManager.getTutorialFile().set("points." + amount + ".location.y", p.getLocation().getBlockY());
		TutorialManager.getTutorialFile().set("points." + amount + ".location.z", p.getLocation().getBlockZ());
		TutorialManager.getTutorialFile().set("points." + amount + ".location.yaw", p.getLocation().getYaw());
		TutorialManager.getTutorialFile().set("points." + amount + ".location.pitch", p.getLocation().getPitch());
		
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix() + " &aSet tutorial point #" + amount + "! There are currently " + amount + " points set!"));
		
		return true;
		
	}

}
