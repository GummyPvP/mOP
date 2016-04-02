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
	
	public void startCombatTimer(final Player p) {
		
		combatTimer.put(p.getName(), Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			public void run() {
				
				if (combatTime.get(p.getName()) <= 0) {
					
					combatTime.keySet().remove(p.getName());
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatManager.getInstance().getChatPrefix()
											+ " &aYou are no longer in combat! You may log out."));
					
					Bukkit.getScheduler().cancelTask(combatTimer.get(p.getName()));
				} else timerMap.replace(p.getName(), combatTime.get(p.getName()), (combatTime.get(p.getName()) - 1));
			}

		}, 0L, 20L));
		
	}
	
	public void forceCombatRemove(Player p) {
		
		combatTimer.remove(p.getName());
		inCombat.put(p.getName(), false);
		
	}
	
	// pearl
	
	public void setPearlTimer(Player p, int integer) {
		
		timerMap.put(p.getName(), integer);
		
	}
	
	public boolean isInPearlTimer(Player p) {
		
		return timerMap.containsKey(p.getName());
		
	}
	
	public int getPearlTime(Player p) {
		
		return timerMap.get(p.getName());
		
	}
	
	public void pearlDelay(final Player p) {

		runMap.put(p.getName(), Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			public void run() {
				
				if (timerMap.get(p.getName()) <= 0) {
					
					timerMap.keySet().remove(p.getName());
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8» &aYou can use another enderpearl!"));
					
					Bukkit.getScheduler().cancelTask(runMap.get(p.getName()));
				} else timerMap.replace(p.getName(), timerMap.get(p.getName()), (timerMap.get(p.getName()) - 1));
			}

		}, 0L, 20L));
	}
	
}