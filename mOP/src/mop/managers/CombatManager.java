package mop.managers;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import mop.main.Main;

public class CombatManager {
	
	public static int delay = 15, pearlDelay = 10;
	
	public HashMap<String, Boolean> inCombat = new HashMap<String, Boolean>();
	public HashMap<String, Integer> combatTime = new HashMap<String, Integer>();
	public HashMap<String, Integer> combatTimer = new HashMap<String, Integer>();
	public HashMap<String, Integer> timerMap = new HashMap<String, Integer>();
	public HashMap<String, Integer> runMap = new HashMap<String, Integer>();
	
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
		combatTime.put(p.getName(), delay);
		
	}
	
	public int getDelayTime(Player p) {
		
		return combatTime.get(p.getName());
		
	}
	
	public void setDelayTime(Player p, int delay) {
		
		combatTime.replace(p.getName(), delay);
		
	}
	
	public int getRunnable(Player p) {
		
		return combatTimer.get(p.getName());
		
	}
	
	public void setRunnable(Player p, int runnable) {
		
		combatTimer.put(p.getName(), runnable);
		
	}
	
	public void forceCombatRemove(Player p) {
		
		combatTimer.remove(p.getName());
		inCombat.put(p.getName(), false);
		
	}
	
	// pearl
	
	public void setPearlTimer(Player p, int integer) {
		
		timerMap.replace(p.getName(), integer);
		
	}
	
	public boolean isInPearlTimer(Player p) {
		
		return timerMap.containsKey(p.getName());
		
	}
	
	public int getPearlTime(Player p) {
		
		return timerMap.get(p);
		
	}
	
	public void pearlDelay(final Player p) {

		runMap.put(p.getName(), Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			public void run() {
				if (timerMap.get(p) <= 0) {
					timerMap.keySet().remove(p);
					p.sendMessage(ChatColor.GREEN + "You can throw another pearl!");
					Bukkit.getScheduler().cancelTask(runMap.get(p));
				} else {
					timerMap.replace(p.getName(), timerMap.get(p.getName()), (timerMap.get(p.getName()) - 1));
				}
			}

		}, 0L, 20L));
	}
	
}