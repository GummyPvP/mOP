package mop.tutorial.utils;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import mop.main.Main;

public class TutorialManager {
	
	private static TutorialManager configuration = new TutorialManager("tutorial");
	
	public static TutorialManager getTutorialFile() {
		return configuration;
	}
		
	private File file;
	private FileConfiguration config;
	
	private TutorialManager(String fileName) {
		
		if (!Main.getPlugin().getDataFolder().exists()) {
			
			Main.getPlugin().getDataFolder().mkdir();
			
		}
		
		file = new File(Main.getPlugin().getDataFolder(), fileName + ".yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public void set(String path, Object value) {
		config.set(path, value);
		save();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String path) {
		
		return (T) config.get(path);
		
	}
	
	public Set<String> getKeys() {
		return config.getKeys(false);
	}
	
	public List<String> getStringList(String path) {
		
		return config.getStringList(path);
		
	}
	
	public boolean contains(String path) {
		return config.contains(path);
	}
	
	public ConfigurationSection createSection(String path) {
		ConfigurationSection section = config.createSection(path);
		save();
		return section;
	}
	
	public ConfigurationSection getSection(String path) {
		
		ConfigurationSection section = config.getConfigurationSection(path);
		return section;
		
	}
	
	public void save() {
		try {
			config.save(file);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getBoolean(String string) {
		return config.getBoolean(string);
	}
	
	public Float getFloat(String string) {
		
		return ((float) config.getDouble(string));
		
	}
	
	public Double getDouble(String string) {
		
		return config.getDouble(string);
		
	}
	
	public int getInt(String string) {
		return config.getInt(string);
	}
}