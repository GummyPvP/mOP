package mop.managers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class IPFilter {
	
	public IPFilter() {

	}

	static IPFilter instance = new IPFilter();

	public static IPFilter getInstance() {
		return instance;
	}
	
	String dir =  "plugins/mOP/ip.yml"; 
	
	public void setupConfig() {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		if (file.exists() == false) {
			
		try {
			file.createNewFile();
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
		
	}
	
	public void setupPlayer(Player p) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		if (config.contains("filter." + p.getName()) == false) {
			config.set("filter." + p.getName() +  ".ip", p.getAddress().getAddress().getHostAddress());
			config.set("filter." + p.getName() +  ".status", false);
			config.set("filter." + p.getName() +  ".logs", " ");

		}
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public FileConfiguration getConfig() {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config;
	}
	public String getIP(Player p) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getString("filter." + p.getName() + ".ip");
		
	}
	public void setIP(Player p, String ip) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
		
		config.set("filter." + p.getName() + ".ip", ip);
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setIP(String p, String ip) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
		
		config.set("filter." + p + ".ip", ip);
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void log(Player p, String ip) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		
	    Date date = new Date();
	    DateFormat filenameDateFormat = new SimpleDateFormat("[dd-MM-yyyy][HH:mm:ss]");
		
		List<String> current = new ArrayList<String>();
		current.clear();
		List<String> msg = null;
		msg = config.getStringList("filter." + p.getName() + ".logs");
		current.add("IP: " + ip + " - TIME: " + filenameDateFormat.format(date));
		current.addAll(msg);
		config.set("filter." + p.getName() + ".logs", current);
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<String> getLogs(Player p) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getStringList("filter." + p.getName() + ".logs");
	}
	public List<String> getLogs(String p) {
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getStringList("filter." + p + ".logs");
	}
	public boolean getStatus(Player p) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getBoolean("filter." + p.getName() + ".status");
	}
	public boolean getStatus(String p) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getBoolean("filter." + p + ".status");
	}
	public void setStatus(Player p, boolean status) {
	
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		config.set("filter." + p.getName() + ".status", status);
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void setStatus(String p, boolean status) {
		
		File file = new File(dir);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		config.set("filter." + p + ".status", status);
		
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
