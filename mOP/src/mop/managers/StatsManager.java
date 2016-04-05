package mop.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class StatsManager {

	private StatsManager() {
	}

	static StatsManager instance = new StatsManager();

	public static StatsManager getInstance() {
		return instance;

	}

	Plugin p;

	FileConfiguration config;
	File cfile;

	public void setup(Plugin p) {
		cfile = new File(p.getDataFolder(), "stats.yml");
		config = YamlConfiguration.loadConfiguration(cfile);
		config.options().copyDefaults(true);
		saveConfig();
		this.p = p;

		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();

		}

	}

	public FileConfiguration getConfig() {
		return config;

	}

	public void saveConfig() {
		try {
			config.save(cfile);

		} catch (IOException e) {
			Bukkit.getServer().getLogger()
					.severe(ChatColor.RED + "Could not save stats.yml!");

		}
	}

	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);

	}

	public PluginDescriptionFile getDesc() {
		return p.getDescription();

	}

	public Plugin getPlugin() {
		return p;

	}

}