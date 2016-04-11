package mop.listeners;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mop.economy.api.mEconAPI;
import mop.managers.ConfigManager;
import mop.managers.CrateGUI;
import mop.managers.KeyType;
import mop.managers.Manager;
import mop.managers.Utils;
import mop.managers.VoucherType;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onVoucherUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().getType() != Material.PAPER)
			return;

		if (!p.getItemInHand().hasItemMeta())
			return;

		if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSlime Kit &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &a&lSlime Kit &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gkit " + p.getName() + " slime");
			return;
		
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&9&lBlaze Spawner Voucher &7&o(Right click to redeem)"))) {
			
			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &9&lBlaze Spawner &bVoucher!"));
			
			ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
			
			ItemMeta spawnerIM = spawnerItem.getItemMeta();
			
			spawnerIM.setDisplayName(ChatColor.GREEN + "Blaze Spawner");
			spawnerIM.setLore(Arrays.asList("This is a Blaze Spawner!", "Place it where you want mobs to spawn"));
			
			spawnerItem.setItemMeta(spawnerIM);
			
			p.getInventory().addItem(spawnerItem);
			
			
			p.updateInventory();
			
			return;
			
			
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&e&lCreeper Spawner Voucher &7&o(Right click to redeem)"))) {
			
			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &e&lCreeper Spawner &bVoucher!"));
			
			ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
			
			ItemMeta spawnerIM = spawnerItem.getItemMeta();
			
			spawnerIM.setDisplayName(ChatColor.GREEN + "Creeper Spawner");
			spawnerIM.setLore(Arrays.asList("This is a Creeper Spawner!", "Place it where you want mobs to spawn"));
			
			spawnerItem.setItemMeta(spawnerIM);
			
			p.getInventory().addItem(spawnerItem);
			
			p.updateInventory();
			
			return;
			
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSlime Spawner Voucher &7&o(Right click to redeem)"))) {
			
			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &a&lSlime Spawner &bVoucher!"));
			
			ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
			
			ItemMeta spawnerIM = spawnerItem.getItemMeta();
			
			spawnerIM.setDisplayName(ChatColor.GREEN + "Slime Spawner");
			spawnerIM.setLore(Arrays.asList("This is a Slime Spawner!", "Place it where you want mobs to spawn"));
			
			spawnerItem.setItemMeta(spawnerIM);
			
			p.getInventory().addItem(spawnerItem);
			
			
			p.updateInventory();
			
			
			
			return;
			
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&a&lKeys &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &a&lKeys &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			int keyamount = 1;
			Random key = new Random();
			Random amount = new Random();
			if (amount.nextInt(4) == 0) {
				keyamount = 3;
			} else if (amount.nextInt(4) == 1) {
				keyamount = 3;
			} else if (amount.nextInt(4) == 2) {
				keyamount = 2;
			} else if (amount.nextInt(4) == 3) {
				keyamount = 2;
			} else {
				keyamount = 1;
			}
			if (key.nextInt(2) == 0) {
				if (keyamount == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Rare key!"));
				} else {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Rare keys!"));
				}
				if (keyamount == 3) {
					Manager.getInstance().giveKey(p, KeyType.RARE);
					Manager.getInstance().giveKey(p, KeyType.RARE);
					Manager.getInstance().giveKey(p, KeyType.RARE);
				} else if (keyamount == 2) {
					Manager.getInstance().giveKey(p, KeyType.RARE);
					Manager.getInstance().giveKey(p, KeyType.RARE);
				} else if (keyamount == 1) {
					Manager.getInstance().giveKey(p, KeyType.RARE);
				}
			} else if (key.nextInt(2) == 1) {
				if (keyamount == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Uncommon key!"));
				} else {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Uncommon keys!"));
				}
				if (keyamount == 3) {
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
				} else if (keyamount == 2) {
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
				} else if (keyamount == 1) {
					Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
				}
			} else {
				if (keyamount == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Common key!"));
				} else {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &b" + p.getName() + " has won " + keyamount + " Common keys!"));
				}
				if (keyamount == 3) {
					Manager.getInstance().giveKey(p, KeyType.COMMON);
					Manager.getInstance().giveKey(p, KeyType.COMMON);
					Manager.getInstance().giveKey(p, KeyType.COMMON);
				} else if (keyamount == 2) {
					Manager.getInstance().giveKey(p, KeyType.COMMON);
				} else if (keyamount == 1) {
					Manager.getInstance().giveKey(p, KeyType.COMMON);
				}
			}
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&c&lHaribo Kit &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &c&lHaribo Kit &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
					"gkit " + p.getName() + " haribo");
			return;

		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&4&lGummy Kit &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &4&lGummy Kit &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gkit " + p.getName() + " gummy");
			return;

		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&e&lRandom &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &e&lRandom &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

			Random r = new Random();
			if (r.nextInt(5) == 0) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"gkit " + p.getName() + " gummy");
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &b" + p.getName() + " has won a Gummy Kit!"));

			} else if (r.nextInt(5) == 1) {
				mEconAPI.addMoney(p, 100000);
				Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " has won 100K!"));
			} else if (r.nextInt(5) == 2) {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &b" + p.getName() + " has won a money party for all online players!"));
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					online.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 1F, 1F);
					mEconAPI.addMoney(online, 500000);
					online.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&l» &aDeposited $500,000 dollars into your account!"));
				}

			} else if (r.nextInt(5) == 3) {
				Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " has won a rare key!"));
				Manager.getInstance().giveKey(p, KeyType.RARE);

			} else if (r.nextInt(5) == 4) {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &b" + p.getName() + " has won 100 mcMMO credits!"));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "addcredits " + p.getName() + " 100");
			} else {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&8&l» &b" + p.getName() + " has won a common key!"));
				Manager.getInstance().giveKey(p, KeyType.COMMON);
			}
		} else if (p.getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSloom Kit &7&o(Right click to redeem)"))) {

			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " has redeemed a &a&lSloom Kit &bVoucher!"));

			if (p.getItemInHand().getAmount() == 1)
				p.getInventory().removeItem(p.getItemInHand());
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gkit " + p.getName() + " sloom");
			return;
		}
	}

	@EventHandler
	public void crate(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.isSneaking() == true)
			return;
		if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_AIR))
			return;
		
		if (e.getClickedBlock().getType() != Material.CHEST)
			return;
		
		if (p.getItemInHand().getType() == Material.TRIPWIRE_HOOK) return;
		
		String location = e.getClickedBlock().getLocation().getWorld().getName() + ":"
				+ e.getClickedBlock().getLocation().getBlockX() + ":" + e.getClickedBlock().getLocation().getBlockY()
				+ ":" + e.getClickedBlock().getLocation().getBlockZ();
		if (ConfigManager.getInstance().checkLocation(location) == false)
			return;

		CrateGUI cgi = new CrateGUI(p);
		cgi.openInventory(p);
		e.setCancelled(true);
		return;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_AIR))
			return;
		if (p.getItemInHand().getType() != Material.TRIPWIRE_HOOK) return;
		
		if (p.getItemInHand().hasItemMeta() == false) return;
		
		if (p.getItemInHand().getItemMeta().hasLore() == false) return;
		if (e.getClickedBlock().getType() != Material.CHEST)
			return;
		
		String location = e.getClickedBlock().getLocation().getWorld().getName() + ":"
				+ e.getClickedBlock().getLocation().getBlockX() + ":" + e.getClickedBlock().getLocation().getBlockY()
				+ ":" + e.getClickedBlock().getLocation().getBlockZ();
		if (ConfigManager.getInstance().checkLocation(location) == false)
			return;
		
		e.setCancelled(true);
		
		Random r = new Random();

		// Common Key //
		
		switch (ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName())) {
		case "Common Crate Key":
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bYou are opening a &aCommon Crate&b..."));
			
			p.playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, 5);
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			
			if (p.getItemInHand().getAmount() == 1) {
				
				p.getInventory().removeItem(p.getItemInHand());
				
			} else p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			p.updateInventory();
			
		switch (r.nextInt(4)) {
		case 0:
			
			mEconAPI.addMoney(p, 600000);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l» &b" + p.getName() + " won... $600,000 in cash from a &acommon crate!"));
			
			break;
			
		case 1:
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... a Haribo Sword from a &acommon crate!"));
			
			ItemStack elite = new ItemStack(Material.DIAMOND_SWORD);
			
			ItemMeta im = elite.getItemMeta();
			
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9[&cHaribo Sword&9]"));
			
			im.addEnchant(Enchantment.DURABILITY, 7, true);
			im.addEnchant(Enchantment.FIRE_ASPECT, 7, true);
			im.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
			im.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
			
			elite.setItemMeta(im);
			
			p.getInventory().addItem(elite);
			
			p.updateInventory();
			
			break;
			
		case 2:
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "addcredits " + p.getName() + " 25");
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &c25 mcMMO credits &bfrom a &acommon crate!"));
			
			break;

		default:
			
			
			Manager.getInstance().giveKey(p, KeyType.UNCOMMON);
			p.updateInventory();
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... an &6Uncommon Crate Key &bfrom a &acommon crate!"));
			
			break;
		}
			
			break;
			
		// Uncommon crate key
			
		case "Uncommon Crate Key":
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bYou are opening a &6Uncommon Crate&b..."));
			
			p.playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, 5);
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			
			if (p.getItemInHand().getAmount() == 1) {
				
				p.getInventory().removeItem(p.getItemInHand());
				
			} else p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			p.updateInventory();
			
		switch (r.nextInt(4)) {
		case 0:
			
			if (r.nextInt(11) == 0) {
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &ca Rare Crate Key &bfrom an &6Uncommon Crate&a!"));
				
				Manager.getInstance().giveKey(p, KeyType.RARE);
				
			} else {
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &aa Slime Kit Voucher &bfrom an &6Uncommon Crate&a!"));
				Manager.getInstance().giveVoucher(p, VoucherType.SLIMEKIT);
				
				p.updateInventory();
				
			}
			
			break;
			
		case 1:
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &a$1,200,000 dollars &bfrom an &6Uncommon Crate&a!"));
			mEconAPI.addMoney(p, 1200000);
			
			break;
			
		case 2:
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &aa Creeper Spawner Voucher &bfrom an &6Uncommon Crate&a!"));
			
			Manager.getInstance().giveVoucher(p, VoucherType.CREEPER_SPAWNER);
			
			break;

		default:
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &aa Blaze Spawner Voucher &bfrom an &6Uncommon Crate&a!"));
			
			Manager.getInstance().giveVoucher(p, VoucherType.BLAZE_SPAWNER);
			
			break;
		}
			
			break;
			
			// Rare Crate
			
		case "Rare Crate Key":
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bYou are opening a &6Uncommon Crate&b..."));
			
			p.playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, 5);
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			
			if (p.getItemInHand().getAmount() == 1) {
				
				p.getInventory().removeItem(p.getItemInHand());
				
			} else p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			p.updateInventory();
			
			switch (r.nextInt(3)) {
			case 0:
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &a&la Slime Spawner Voucher &bfrom an &6Uncommon Crate&a!"));
				
				Manager.getInstance().giveVoucher(p, VoucherType.SLIME_SPAWNER);
				
				break;
				
			case 1:
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "addcredits " + p.getName() + " 75");
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &c75 mcMMO credits &bfrom a &c&lRare Crate!"));
				
				break;

			default:
				
				mEconAPI.addMoney(p, 2500000);
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &a&l$2,500,000 million dollars &bfrom a &c&lRare Crate!"));
				
				break;
			}
			
			break;
			
		case "Legendary Crate Key":
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &bYou are opening a &5&lLegendary Crate&b..."));
			
			p.playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, 5);
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			
			if (p.getItemInHand().getAmount() == 1) {
				
				p.getInventory().removeItem(p.getItemInHand());
				
			} else p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
			
			p.updateInventory();
			
			switch (r.nextInt(2)) {
			
			case 0:
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &4&la Sloom Kit voucher &bfrom a &5&lLegendary Crate!"));
				Manager.getInstance().giveVoucher(p, VoucherType.SLOOMKIT);
				
				break;
				
			case 1:
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &b" + p.getName() + " won... &a&lKit Spawner &bfrom a &5&lLegendary Crate!"));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gkit " + p.getName() + " spawner");
				
				break;
				
			default:
				break;
				
			}
			
			break;
			
		default:
			break;
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSignUse(PlayerInteractEvent e) {

		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
			return;

		if (e.getClickedBlock() == null || e.getClickedBlock().getType() != Material.WALL_SIGN)
			return;

		if (!(e.getClickedBlock().getState() instanceof Sign))
			return;

		Sign sign = (Sign) e.getClickedBlock().getState();
		Player p = e.getPlayer();

		String[] lines = sign.getLines();

		switch (ChatColor.stripColor(lines[0])) {

		case "[Sell]":

			if (lines[1] != null) {

				if (lines[0].equals(ChatColor.GREEN + "[Sell]")) {

					int amount;
					int cost;

					if (Utils.isInt(lines[2])) {

						amount = Integer.parseInt(lines[2]);

					} else
						amount = 1;

					if (lines[3].contains("$") && Utils.isInt(lines[3].replaceAll("[$]", "").trim())) {

						cost = Integer.parseInt(lines[3].replaceAll("[$]", "").trim());

					} else if (Utils.isInt(lines[3])) {

						cost = Integer.parseInt(lines[3]);

					} else
						cost = 1;

					if (Utils.onlyContainsLetters(lines[1])) {

						if (p.getInventory().containsAtLeast(
								new ItemStack(Material.getMaterial(lines[1].replace(" ", "_").toUpperCase())),
								amount)) {

							Utils.removeItems(p.getInventory(),
									Material.getMaterial(lines[1].replace(" ", "_").toUpperCase()), 0, amount);
							p.updateInventory();

							mEconAPI.addMoney(p, cost);

							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYou sold &e" + amount + " "
									+ lines[1].trim().replaceAll("_", " ") + "(s) &aand received &e$" + cost + "&a!"));

							return;
						} else
							p.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&8» &cYou do not have enough items to sell!"));

						return;
					}

					if (Utils.isInt(lines[1])) {

						if (p.getInventory().containsAtLeast(
								new ItemStack(Material.getMaterial(Integer.parseInt(lines[1]))), amount)) {

							String material = Material.getMaterial(Integer.parseInt(lines[1])).toString()
									.replaceAll("_", " ").toLowerCase();
							String materialName = material.substring(0, 1).toUpperCase() + material.substring(1);

							Utils.removeItems(p.getInventory(), Material.getMaterial(Integer.parseInt(lines[1])), 0,
									amount);
							p.updateInventory();

							mEconAPI.addMoney(p, cost);

							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYou sold &e" + amount + " "
									+ materialName + "(s) &aand received &e$" + cost + "&a!"));

							return;
						} else
							p.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&8» &cYou do not have enough items to sell!"));

						return;
					}

					if (Utils.matchesItemId(lines[1])) {

						String[] data = lines[1].split(":");

						ItemStack item = new ItemStack(Material.getMaterial(Integer.parseInt(data[0])), amount);
						item.setDurability(Short.parseShort(data[1]));

						if (p.getInventory().containsAtLeast(item, amount)) {

							String material = Material.getMaterial(Integer.parseInt(data[0])).toString()
									.replaceAll("_", " ").toLowerCase();
							String materialName = material.substring(0, 1).toUpperCase() + material.substring(1);

							Utils.removeItems(p.getInventory(), Material.getMaterial(Integer.parseInt(data[0])),
									Integer.parseInt(data[1]), amount);
							p.updateInventory();

							mEconAPI.addMoney(p, cost);

							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYou sold &e" + amount + " "
									+ materialName + "(s) &aand received &e$" + cost + "&a!"));

							return;
						} else
							p.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&8» &cYou do not have enough items to sell!"));

						return;
					}

				} else
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8» &cThis shop sign is not configured correctly! Please contact an administrator."));
			}
			break;

		case "[Buy]":

			if (lines[1] != null) {
				if (lines[0].equals(ChatColor.GREEN + "[Buy]")) {
					ItemStack item;
					int amount;
					int cost;

					if (Utils.isInt(lines[2])) {

						amount = Integer.parseInt(lines[2]);

					} else
						amount = 1;

					if (lines[3].contains("$") && Utils.isInt(lines[3].replaceAll("[$]", "").trim())) {

						cost = Integer.parseInt(lines[3].replaceAll("[$]", "").trim());

					} else if (Utils.isInt(lines[3])) {

						cost = Integer.parseInt(lines[3]);

					} else
						cost = 1;
					
					if (lines[1].contains(" Spawner")) {
						
						if (lines[1].contains("Iron")) {
							
							if (mEconAPI.removeMoney(p, cost) == true) {
							
							ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
							
							ItemMeta spawnerIM = spawnerItem.getItemMeta();
							
							spawnerIM.setDisplayName(ChatColor.GREEN + "Iron Golem Spawner");
							spawnerIM.setLore(Arrays.asList("This is an Iron Golem Spawner!", "Place it where you want mobs to spawn"));
							
							spawnerItem.setItemMeta(spawnerIM);
							
							p.getInventory().addItem(spawnerItem);

							return;
							} else 
								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &cYou do not have the required amount of funds to purchase this item!"));
							return;
						}
						
						if (lines[1].contains("Magma")) {
							
							if (mEconAPI.removeMoney(p, cost)) {
							
							ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
							
							ItemMeta spawnerIM = spawnerItem.getItemMeta();
							
							spawnerIM.setDisplayName(ChatColor.GREEN + "Magma Cube Spawner");
							spawnerIM.setLore(Arrays.asList("This is a Magma Cube Spawner!", "Place it where you want mobs to spawn"));
							
							spawnerItem.setItemMeta(spawnerIM);
							
							p.getInventory().addItem(spawnerItem);
							
							return;
							} else 
								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &cYou do not have the required amount of funds to purchase this item!"));
							return;
							
						}
						
						if (mEconAPI.removeMoney(p, cost)) {
						
						String spawnerType = lines[1].split(" ")[0].toUpperCase();
						
						String spawnerName = spawnerType.substring(0, 1).toUpperCase() + spawnerType.substring(1).toLowerCase();
						
						ItemStack spawnerItem = new ItemStack(Material.MOB_SPAWNER);
						
						ItemMeta spawnerIM = spawnerItem.getItemMeta();
						
						spawnerIM.setDisplayName(ChatColor.GREEN + spawnerName + " Spawner");
						spawnerIM.setLore(Arrays.asList("This is a " + spawnerName + " Spawner!", "Place it where you want mobs to spawn"));
						
						spawnerItem.setItemMeta(spawnerIM);
						
						p.getInventory().addItem(spawnerItem);
						
						return;
						} else 
							p.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&8» &cYou do not have the required amount of funds to purchase this item!"));
						return;
					}

					if (mEconAPI.removeMoney(p, cost)) {

						if (Utils.onlyContainsLetters(lines[1])) {

								ItemStack shopItem = new ItemStack(Material.getMaterial(lines[1].replace(" ", "_").toUpperCase()), amount);

								p.getInventory().addItem(shopItem);
								
								
								p.updateInventory();

								p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYou sold &e" + amount + " "
										+ lines[1].trim().replaceAll("_", " ") + "(s) &aand received &e$" + cost + "&a!"));

								return;

						}

						if (Utils.isInt(lines[1])) {

							try {

								String material = Material.getMaterial(Integer.parseInt(lines[1])).toString();
								String materialName = material.substring(0, 1).toUpperCase() + material.substring(1);

								item = new ItemStack(Material.getMaterial(Integer.parseInt(lines[1])), amount);
								p.getInventory().addItem(item);

								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &aYou bought &e" + amount + " " + materialName.replaceAll("_", " ")
												+ "(s) &aand your account was debited &e$" + cost + "&a!"));

							} catch (Exception e2) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &cThis shop sign is not configured correctly! Please contact an administrator."));
							}

							return;
						}

						if (Utils.matchesItemId(lines[1])) {

							String[] data = lines[1].split(":");

							try {

								String material = Material.getMaterial(Integer.parseInt(data[0])).toString();
								String materialName = material.substring(0, 1).toUpperCase() + material.substring(1);

								item = new ItemStack(Material.getMaterial(Integer.parseInt(data[0])), amount,
										Short.parseShort(data[1]));
								p.getInventory().addItem(item);

								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &aYou bought &e" + amount + " " + materialName.replaceAll("_", " ")
												+ "(s) &aand your account was debited &e$" + cost + "&a!"));

							} catch (Exception e2) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&',
										"&8» &cThis shop sign is not configured correctly! Please contact an administrator."));
							}

							return;
						}

					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8» &cYou do not have the required amount of funds to purchase this item!"));

				} else
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8» &cThis shop sign is not configured correctly! Please contact an administrator."));
			}
			break;
		}
	}
}
