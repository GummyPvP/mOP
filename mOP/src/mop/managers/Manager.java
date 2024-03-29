package mop.managers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import mauth.api.mAuthAPI;

public class Manager {
	
	public HashMap<Player, Boolean> jellyLegs = new HashMap<Player, Boolean>();

	FileConfiguration config = StatsManager.getInstance().getConfig();

	private Manager() {
	}

	static Manager instance = new Manager();

	public static Manager getInstance() {
		return instance;
	}
	public void addPotionEffect(Player p, PotionEffectType type, int level, int duration) {
		
		
    	p.addPotionEffect(new PotionEffect(type, 9 * duration, level));
		
		
	}
	public String formatTimeToString(Long past, Long current, Integer delay) {

		StringBuilder sb = new StringBuilder();
		
		Long nowTime = ((current - past) / 1000);
		Long seconds = (delay - nowTime);
		Long minutes = (seconds / 60);
		Long hours = ((seconds / 60) / 60);
		Long days = (((seconds / 60) / 60) / 24);
		
		String secondString = Math.round(seconds) == 1 ? " second " : " seconds ";
		String minuteString = Math.round(minutes) == 1 ? " minute " : " minutes ";
		String hourString = Math.round(hours) == 1 ? " hour " : " hours ";
		String dayString = Math.round(days) == 1 ? " day " : " days ";
	
		
		if (seconds <= 59) {
			sb.setLength(0);
			sb.append(Math.round(seconds) + secondString);
		}
		if (seconds >= 60) {
			
			sb.setLength(0);
			sb.append(Math.round(minutes) + minuteString + Math.round(seconds - (minutes * 60)) + secondString);
		}
				
		if ((seconds / 60) >= 60) {
			sb.setLength(0);
			sb.append(Math.round(hours) + hourString + Math.round((minutes - (hours * 60))) + minuteString);
			
		}
				
		if (((seconds / 60) / 60) >= 24) {
			sb.setLength(0);
			sb.append(Math.round(days) + dayString + Math.round(hours - (days * 24)) + hourString + Math.round(minutes - (hours * 60)) + minuteString);
		}
				
		return sb.toString();

	}

	public void adminMessage(String msg) {
		Player xxkguyxx = Bukkit.getPlayer("xXkguyXx");
		Player googlelover = Bukkit.getPlayer("Googlelover1234");
		Player Acyric = Bukkit.getPlayer("Acyric");
		Player mckpvp = Bukkit.getPlayer("mckpvp");
		Player Emperor_Koala = Bukkit.getPlayer("Emperor_Koala");
		if (xxkguyxx != null) {
			if (mAuthAPI.isAuthenticated(xxkguyxx) == true) {
			xxkguyxx.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (googlelover != null) {
			if (mAuthAPI.isAuthenticated(googlelover) == true) {
			googlelover.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (Acyric != null) {
			if (mAuthAPI.isAuthenticated(Acyric) == true) {
			Acyric.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (mckpvp != null) {
			if (mAuthAPI.isAuthenticated(mckpvp) == true) {
			mckpvp.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (Emperor_Koala != null) {
			if (mAuthAPI.isAuthenticated(Emperor_Koala) == true) {
			Emperor_Koala.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void scoreboardRefresh(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("stats", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.YELLOW + "Your Stats");
		Score kills = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.WHITE + "� " + ChatColor.AQUA
						+ "Kills"));
		kills.setScore(StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".kills"));
		Score deaths = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.WHITE + "� " + ChatColor.AQUA
						+ "Deaths"));
		deaths.setScore(StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".deaths"));
		Score ks = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE
				+ "� " + ChatColor.AQUA + "Killstreak"));
		ks.setScore(StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".killstreak"));
		p.setScoreboard(board);
	}

	public void messageStats(Player p, CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&6&l&m[ ----&8&l&m [&b&l" + p.getName()
						+ "'s Stats&8&l&m]&6&l&m ---- ]"));
		double kills = StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".kills");
		double deaths = StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".deaths");
		int ks = StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".killstreak");
		double kd = kills / deaths;
		DecimalFormat dm = new DecimalFormat("#.##");
		String kdrounded = dm.format(kd);
		sender.sendMessage(ChatColor.AQUA + "Kills: " + kills);
		sender.sendMessage(ChatColor.AQUA + "Deaths: " + deaths);
		if (deaths <= 0.0) {
			sender.sendMessage(ChatColor.AQUA + "Kill/Death Ratio: " + kills);
		} else {
			sender.sendMessage(ChatColor.AQUA + "Kill/Death Ratio: "
					+ kdrounded);
		}
		sender.sendMessage(ChatColor.AQUA + "Killstreak: " + ks);
	}

	public void messageStats(OfflinePlayer p, CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&6&l&m[ ----&8&l&m [&b&l" + p.getName()
						+ "'s Stats&8&l&m]&6&l&m ---- ]"));
		double kills = StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".kills");
		double deaths = StatsManager.getInstance().getConfig()
				.getInt("users." + p.getName() + ".deaths");
		double kd = kills / deaths;
		DecimalFormat dm = new DecimalFormat("#.##");
		String kdrounded = dm.format(kd);
		sender.sendMessage(ChatColor.AQUA + "Kills: " + kills);
		sender.sendMessage(ChatColor.AQUA + "Deaths: " + deaths);
		if (deaths <= 0.0) {
			sender.sendMessage(ChatColor.AQUA + "Kill/Death Ratio: " + kills);
		} else {
			sender.sendMessage(ChatColor.AQUA + "Kill/Death Ratio: "
					+ kdrounded);
		}
	}

	public void resetStats(Player p) {
		StatsManager.getInstance().getConfig()
				.set("users." + p.getName() + ".kills", 0);
		StatsManager.getInstance().getConfig()
				.set("users." + p.getName() + ".deaths", 0);
		StatsManager.getInstance().getConfig()
				.set("users." + p.getName() + ".killstreak", 0);
		StatsManager.getInstance().saveConfig();
		StatsManager.getInstance().reloadConfig();
	}
	public void giveKey(Player p, KeyType type) {
		
		switch (type) {
		case COMMON:
			
			ItemStack commonHook = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta im = commonHook.getItemMeta();
			im.setDisplayName(ChatColor.GREEN + "Common Crate Key");
			im.setLore(Arrays.asList("Use this on a crate to get rewards!"));
			commonHook.setItemMeta(im);
			p.getInventory().addItem(commonHook);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &aCommon Crate Key &7added to your inventory."));
			
			break;
			
		case UNCOMMON:
			
			ItemStack uncommonHook = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta uncommonIM = uncommonHook.getItemMeta();
			uncommonIM.setDisplayName(ChatColor.GOLD + "Uncommon Crate Key");
			uncommonIM.setLore(Arrays.asList("Use this on a crate to get rewards!"));
			uncommonHook.setItemMeta(uncommonIM);
			p.getInventory().addItem(uncommonHook);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &6Uncommon Crate Key &7added to your inventory."));
			
			break;
			
		case RARE:
			
			ItemStack rare = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta rareIM = rare.getItemMeta();
			rareIM.setDisplayName(ChatColor.RED + "Rare Crate Key");
			rareIM.setLore(Arrays.asList("Use this on a crate to get rewards!"));
			rare.setItemMeta(rareIM);
			p.getInventory().addItem(rare);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cRare Crate Key &7added to your inventory."));
			
			break;
			
		case LEGENDARY:
			
			ItemStack legendary = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta legendaryIM = legendary.getItemMeta();
			legendaryIM.setDisplayName(ChatColor.DARK_PURPLE + "Legendary Crate Key");
			legendaryIM.setLore(Arrays.asList("Use this on a crate to get rewards!"));
			legendary.setItemMeta(legendaryIM);
			p.getInventory().addItem(legendary);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &5Legendary Crate Key &7added to your inventory."));
			
			break;

		default:
			break;
		}
	}
	
	public void giveVoucher(Player p, VoucherType voucher) {
		if (voucher == VoucherType.SLIMEKIT) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSlime Kit &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA SlimeKit Voucher has been added to your inventory."));
		} else if (voucher == VoucherType.HARIBOKIT) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lHaribo Kit &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.getInventory().addItem(paper);
			p.updateInventory();
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA HariboKit Voucher has been added to your inventory."));
		} else if (voucher == VoucherType.GUMMYKIT) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lGummy Kit &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA GummyKit Voucher has been added to your inventory."));
		} else if (voucher == VoucherType.RANDOM) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lRandom &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Random Voucher has been added to your inventory."));
		} else if (voucher == VoucherType.KEYS) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lKeys &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Keys has been added to your inventory."));
		} else if (voucher == VoucherType.SLOOMKIT) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSloom Kit &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Sloom has been added to your inventory."));
		} else if (voucher == VoucherType.SLIME_SPAWNER) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSlime Spawner Voucher &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Sloom has been added to your inventory."));
		} else if (voucher == VoucherType.CREEPER_SPAWNER) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lCreeper Spawner Voucher &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Sloom has been added to your inventory."));
		} else if (voucher == VoucherType.BLAZE_SPAWNER) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta pmeta = paper.getItemMeta();
			pmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lBlaze Spawner Voucher &7&o(Right click to redeem)"));
			paper.setItemMeta(pmeta);
			p.updateInventory();
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&l� &cA Sloom has been added to your inventory."));
		}
	}
	
	public void setJellyLegsEnabled(Player p, boolean b) {
		
		jellyLegs.put(p, b);
		
	}
	
	public boolean isJellyLegsEnabled(Player p) {
		
		if (jellyLegs.containsKey(p)) {
			
			return jellyLegs.get(p);
			
		} else return false;
	}
}
