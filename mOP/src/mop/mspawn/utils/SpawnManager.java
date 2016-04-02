package mop.mspawn.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SpawnManager {
	
	private SpawnManager() {
		
	}
	
	static SpawnManager instance = new SpawnManager();
	
	public static SpawnManager getInstance() {
		return instance;
	}
	
	public Location getSpawnLocation() {
		
		double x, y, z;
		float yaw, pitch;
		
		World world = Bukkit.getWorld(ConfigManager.getInstance().getConfig().getString("spawn.world"));
		x = ConfigManager.getInstance().getConfig().getDouble("spawn.x");
		y = ConfigManager.getInstance().getConfig().getDouble("spawn.y");
		z = ConfigManager.getInstance().getConfig().getDouble("spawn.z");
		yaw = ConfigManager.getInstance().getConfig().getInt("spawn.yaw");
		pitch = ConfigManager.getInstance().getConfig().getInt("spawn.pitch");
		
		return new Location(world, x, y, z, yaw, pitch);
		
	}
	
	public void setSpawn(Location location) {
		
		ConfigManager.getInstance().getConfig().set("spawn.world", location.getWorld().getName());
		ConfigManager.getInstance().getConfig().set("spawn.x", location.getX());
		ConfigManager.getInstance().getConfig().set("spawn.y", location.getY());
		ConfigManager.getInstance().getConfig().set("spawn.z", location.getZ());
		ConfigManager.getInstance().getConfig().set("spawn.yaw", location.getYaw());
		ConfigManager.getInstance().getConfig().set("spawn.pitch", location.getPitch());
		ConfigManager.getInstance().saveConfig();
		
	}

}
