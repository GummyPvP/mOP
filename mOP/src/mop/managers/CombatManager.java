package mop.managers;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CombatManager {
	
	public static int delay = 15;
	
	public HashMap<String, Boolean> inCombat = new HashMap<String, Boolean>();
	public HashMap<String, Long> combatTime = new HashMap<String, Long>();
	public HashMap<String, BukkitRunnable> combatTimer = new HashMap<String, BukkitRunnable>();
	
	public static CombatManager instance = new CombatManager();
	
	public CombatManager() {
		
	}
	
	public static CombatManager getInstance() {
		return instance;
	}
	
	public boolean isInCombat(Player p) {
		
		return inCombat.containsKey(p.getName()) && inCombat.get(p.getName());
		
	}
	
	public void setInCombat(Player p, boolean b) {
			
		inCombat.put(p.getName(), b);
		
	}
	
	public long getLongTime(Player p) {
		
		return combatTime.get(p.getName());
		
	}
	
	public void setLongTime(Player p, long time) {
		
		combatTime.put(p.getName(), time);
		
	}
	
	public BukkitRunnable getRunnable(Player p) {
		
		return combatTimer.get(p.getName());
		
	}
	
	public void setRunnable(Player p, BukkitRunnable runnable) {
		
		combatTimer.put(p.getName(), runnable);
		
	}
	
	public long getCurrentDelay(Player p) {
		
		long timeInSeconds = (delay
				- (System.currentTimeMillis() - CombatManager.getInstance().getLongTime(p)) / 1000);
		
		return timeInSeconds;
		
	}
	
	public void forceCombatRemove(Player p) {
		
		combatTimer.remove(p.getName());
		inCombat.put(p.getName(), false);
		
	}
}