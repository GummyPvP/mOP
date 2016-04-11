package mop.cmds;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import mop.managers.ChatManager;
import mop.managers.Manager;
import net.md_5.bungee.api.ChatColor;

public class Pot implements CommandExecutor {
	
	HashMap<Player, Long> cooldown = new HashMap<Player, Long>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pot")) {
			if (!sender.hasPermission("mop.pot")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (cooldown.containsKey(p) == true) {
				
				sender.sendMessage(ChatColor.RED + "You can not use that for another " +
				Manager.getInstance().formatTimeToString(cooldown.get(p), System.currentTimeMillis(), 3600));
				
				return true;
			}
			
			
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 18000, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 4000, 3));
			
			cooldown.put(p, System.currentTimeMillis());
			
			
			
			p.sendMessage(ChatColor.GREEN + "EFFECTS APPLIED!");
			
			return true;
		}
		return true;
	}
}