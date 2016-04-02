package mop.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mop.managers.ChatManager;
import mop.managers.CombatManager;

public class CombatLog implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderPlayerOnly(sender);
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("CombatLog")) {

			if (CombatManager.getInstance().isInCombat(p)) {

				if (CombatManager.getInstance().getDelayTime(p) <= 0) {

					CombatManager.getInstance().forceCombatRemove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &aYou are not in combat. You may log out."));

					return true;
				}

				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cYou are in combat for &e"
						+ CombatManager.getInstance().getDelayTime(p) + " &cmore second(s)!"));

				return true;

			} else
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', "&8&l» &aYou are not in combat. You may log out."));
		}
		
		return true;
	}
}