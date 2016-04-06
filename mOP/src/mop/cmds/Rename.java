package mop.cmds;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mop.managers.ChatManager;

public class Rename implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rename")) {
			
			if (!sender.hasPermission("mop.rename")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			
			if ((p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR)) {
				sender.sendMessage(ChatColor.RED + "You must be holding a item!");
				return true;
			}
			
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Invalid ussage! Please use /rename <Name>");
				return true;
			}
			
			if (args.length >= 1) {
				
		        String name = StringUtils.join(args, ' ', 0, args.length);
		        
		        ItemStack hand = p.getItemInHand();
		        
		        ItemMeta im = hand.getItemMeta();
		        
		        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		        
		        hand.setItemMeta(im);
		        
		        p.setItemInHand(hand);
		        
		        p.updateInventory();
		        
		        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aItem name has been updated!"));
		        
				return true;
			}
		}
		return true;
	}
}