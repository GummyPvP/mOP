package mop.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class MaintenanceManager {
	
	
	private MaintenanceManager() {
	}

	static MaintenanceManager instance = new MaintenanceManager();

	public static MaintenanceManager getInstance() {
		return instance;

	}
	
	boolean enabled = false;
	
    File whitelist = new File("plugins/mOP/","whitelist.yml");
	FileConfiguration whitelistfile = YamlConfiguration.loadConfiguration(whitelist);
	
	public void setup() {
		
		this.saveWhitelistFile();
		
		ArrayList<String> players = new ArrayList<String>();
		
		players.add("xXkguyXx");
		players.add("Dreadmore");
		players.add("Googlelover1234");
		players.add("Emperor_Koala");
		players.add("mckpvp");
		
		getWhitelistFile().addDefault("whitelist", players);
		
		getWhitelistFile().options().copyDefaults(true);
		
		saveWhitelistFile();
		
		
		
	}
	public void saveWhitelistFile() {
		try {
			whitelistfile.save(whitelist);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public FileConfiguration getWhitelistFile() {
		return whitelistfile;
	}
	public void addPlayer(String p) {
		List<String> current = new ArrayList<String>();
		current.clear();
		List<String> msg = null;
		msg = getWhitelistFile().getStringList("whitelist");
		current.add(p);
		current.addAll(msg);
		getWhitelistFile().set("whitelist", current);
		saveWhitelistFile();
	}
	public void removePlayer(String p) {
		getWhitelistFile().getList("whitelist").remove(p);
		saveWhitelistFile();
	}
	public List<String> getWhitelistedPlayers() {
		return getWhitelistFile().getStringList("whitelist");
	}
	public boolean isPlayerWhitelisted(String p) {
		if (getWhitelistFile().getStringList("whitelist").contains(p) == true) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isPlayerWhitelisted(Player p) {
		if (getWhitelistFile().getStringList("whitelist").contains(p.getName()) == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void toggleMaintenace(boolean b) {
		if (b  == true) {
			enabled = true;
		} 
		if (b == false) {
			enabled = false;
	
		}
	}

}
