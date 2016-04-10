package mop.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.managers.ChatManager;

public class Fireball implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			
			return true;
			
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("fireball")) {
			
			if (sender.hasPermission("mop.fireball") == false) {
				
				ChatManager.getInstance().messageNoPermission(sender);
				
				return true;
			}
			
			org.bukkit.entity.Fireball fireball = p.launchProjectile(org.bukkit.entity.Fireball.class);
			
			fireball.setIsIncendiary(true);
			
			fireball.setYield(2);
			
			p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1.0F, 1.0F);
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &aFireBall!"));
			
			return true;
			
			
			
		}
		
		
		
		return false;
	}
}