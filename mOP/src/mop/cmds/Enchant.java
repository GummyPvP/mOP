package mop.cmds;


import mop.managers.ChatManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Enchant implements CommandExecutor {
	
	  private boolean isInt(String s, Player p)
	  {
	    try {
	      Integer.parseInt(s);
	      return true; 
	      } catch (NumberFormatException e) {
	    }
	    return false;
	  }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Console cannot get items!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("enchant")) {
			if (!sender.hasPermission("mop.enchant")) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GOLD + "Enchantments: " + ChatColor.WHITE + 
						"Fire, infin, Knock, Sharp, Arth, Haste, Unbreak, Loot, Fortune, protection, fireprot, silk, thorn." );
				return true;
			}
			if (args.length == 1) {
				sender.sendMessage(ChatColor.RED + "You must supply a enchantment level!");
				return true;
			}
			if (args.length == 2) {
			if (!isInt(args[1], p)) {
				p.sendMessage(ChatColor.RED + "You must supply a enchantment level!");
				return true;
			}
			if (p.getItemInHand() == null) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cYou must be holding a item!" ));
				return true;
			}
			try {
				if (args[0].equalsIgnoreCase("fire")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.FIRE_ASPECT, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("infin")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.ARROW_INFINITE, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("knock")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.KNOCKBACK, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("sharp")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("arth")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("haste")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("unbreak")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("loot")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("fortune")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("protection")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("fireprot")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("silk")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.SILK_TOUCH, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else if (args[0].equalsIgnoreCase("thorn")) {
					 p.getItemInHand().addUnsafeEnchantment(Enchantment.THORNS, Integer.parseInt(args[1]));
					 p.updateInventory();
					 return true;
				} else {
					sender.sendMessage(ChatColor.GOLD + "Enchantments: " + ChatColor.WHITE + 
							"Fire, infin, Knock, Sharp, Arth, Haste, Unbreak, Loot, Fortune, protection, fireprot, silk, thorn." );
					return true;	
				}
			} catch (Exception e) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cYou cannot apply that enchantment to that item!" ));
				return true;
			}
				
			}
		}
		return false;
	}

}
