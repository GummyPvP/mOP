package mop.economy.utils;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class mEcon {

	static Player p;

	@SuppressWarnings("static-access")
	public mEcon(Player p) {

		this.p = p;
	}

	static mEcon instance = new mEcon(p);

	public static mEcon getInstance() {
		return instance;

	}

	String dir = "plugins/mEconomy/money.yml";

	public void setupPlayer() {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		if (!config.contains("balance." + p.getName())) {
			config.set("balance." + p.getName(), 1000);
			try {
				config.save(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean offlinePlayerExsists(OfflinePlayer p) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		if (config.contains("balance." + p.getName())) {
			return true;
		} else {
			return false;
		}
	}

	public void setOfflinePlayerBalance(OfflinePlayer p, int amount) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("balance." + p.getName(), amount);
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addOfflinePlayerMoney(OfflinePlayer p, int amount) {
		this.setOfflinePlayerBalance(p, this.getOfflinePlayerBalance(p) + amount);
	}

	public int getOfflinePlayerBalance(OfflinePlayer p) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		return config.getInt("balance." + p.getName());
	}

	public boolean removeMoneyOfflinePlayer(OfflinePlayer p, int amount) {
		if (this.getOfflinePlayerBalance(p) - amount < 0)
			return false;

		setOfflinePlayerBalance(p, this.getOfflinePlayerBalance(p) - amount);
		return true;
	}

	public int getBalance() {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		return config.getInt("balance." + p.getName());
	}

	public void addMoney(int amount) {
		this.setBalance(this.getBalance() + amount);
	}

	public boolean removeMoney(int amount) {
		if (this.getBalance() - amount < 0)
			return false;

		setBalance(this.getBalance() - amount);
		return true;
	}

	public void setBalance(int amount) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("balance." + p.getName(), amount);
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
