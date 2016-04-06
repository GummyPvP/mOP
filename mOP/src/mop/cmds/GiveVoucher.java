package mop.cmds;


import mop.managers.ChatManager;
import mop.managers.Manager;
import mop.managers.VoucherType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveVoucher implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("givevoucher")) {
			if (sender.hasPermission("mop.givevoucher") == false) {
				ChatManager.getInstance().messageNoPermission(sender);
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', 
						"&8&l» &bCurrent Vouchers:&a SlimeKit, HariboKit, GummyKit, SloomKit, Random, Keys, CreeperSpawner, BlazeSpawner, SlimeSpawner"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c/givevoucher <player> <voucher>"));
				return true;
			}
			if (args.length == 2) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(ChatColor.RED + "Target is offline!");
					return true;
				}
				if (args[1].equalsIgnoreCase("slimekit")) {
				
					Manager.getInstance().giveVoucher(target, VoucherType.SLIMEKIT);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
				} else
				if (args[1].equalsIgnoreCase("haribokit")) {
					Manager.getInstance().giveVoucher(target, VoucherType.HARIBOKIT);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
					
				} else
				if (args[1].equalsIgnoreCase("creeperspawner")) {
					Manager.getInstance().giveVoucher(target, VoucherType.CREEPER_SPAWNER);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
					
				} else
				if (args[1].equalsIgnoreCase("blazespawner")) {
					Manager.getInstance().giveVoucher(target, VoucherType.BLAZE_SPAWNER);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
					
				} else
				if (args[1].equalsIgnoreCase("slimespawner")) {
					Manager.getInstance().giveVoucher(target, VoucherType.SLIME_SPAWNER);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
					
					
				} else
				if (args[1].equalsIgnoreCase("gummykit")) {
					Manager.getInstance().giveVoucher(target, VoucherType.GUMMYKIT);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
				} else
				if (args[1].equalsIgnoreCase("random")) {
					Manager.getInstance().giveVoucher(target, VoucherType.RANDOM);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
				} else
				if (args[1].equalsIgnoreCase("keys")) {
					Manager.getInstance().giveVoucher(target, VoucherType.KEYS);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
				} else
				if (args[1].equalsIgnoreCase("sloomkit")) {
					Manager.getInstance().giveVoucher(target, VoucherType.SLOOMKIT);
					sender.sendMessage(ChatColor.GREEN + "A Voucher has been added to "  + target.getName() + " inventory!");
					return true;
				}
			} 
		}
		return true;
	}
}