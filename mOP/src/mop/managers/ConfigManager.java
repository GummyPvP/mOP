package mop.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class ConfigManager {

	private ConfigManager() {
	}

	static ConfigManager instance = new ConfigManager();

	public static ConfigManager getInstance() {
		return instance;

	}

	Plugin p;

	FileConfiguration config;
	File cfile;

	File crates = new File("plugins/mOP/", "crates.yml");
	FileConfiguration cratesfile = YamlConfiguration.loadConfiguration(crates);

	
	public void setup(Plugin p) {

		try {
			saveCratesConfig();

			ArrayList<String> temp = new ArrayList<String>();
			temp.add("LOC:1");
			temp.add("LOC:2");
			getCratesConfig().addDefault("crates", temp);

			getCratesConfig().options().copyDefaults(true);

			saveCratesConfig();

		} catch (Exception e) {

		}
		cfile = new File(p.getDataFolder(), "config.yml");
		config = p.getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		this.p = p;

		
		
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();

		}
		
		if (getConfig().contains("motd") == false) {
			getConfig().set("motd", "      &b&m-&8»&e&m-&8»&b&m-&8»&e&m-&8» &8[&b✧&8] &b&lGummy PvP &8[&b✧&8] &8«&b&m-&8«&e&m-&8«&b&m-&8«&e&m-&r");
			
			saveConfig();
			
		}

	}

	public FileConfiguration getConfig() {
		return config;

	}

	public FileConfiguration getCratesConfig() {
		return cratesfile;

	}

	public void addLocation(String l) {
		List<String> current = new ArrayList<String>();
		current.clear();
		List<String> msg = null;
		msg = getCratesConfig().getStringList("crates");
		current.add(l);
		current.addAll(msg);
		getCratesConfig().set("crates", current);
		saveCratesConfig();
	}

	public boolean checkLocation(String location) {
		if (getCratesConfig().getStringList("crates").contains(location) == true) {
			return true;
		} else {
			return false;
		}
	}

	public void saveCratesConfig() {
		try {
			cratesfile.save(crates);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveConfig() {
		try {
			config.save(cfile);

		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");

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