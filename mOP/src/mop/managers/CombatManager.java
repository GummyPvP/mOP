package mop.managers;

import org.bukkit.entity.Player;

import mop.listeners.EntityDamageByEntity;

public class CombatManager {
	
	public static int delay = 15;
	
	public static CombatManager instance = new CombatManager();
	
	public CombatManager() {
		
	}
	
	public static CombatManager getInstance() {
		return instance;
	}
	
	public boolean isInCombat(Player p) {
		
		return EntityDamageByEntity.inCombat.containsKey(p.getName()) && EntityDamageByEntity.inCombat.get(p.getName());
		
	}
	
	public long getLongTime(Player p) {
		
		return EntityDamageByEntity.combatTime.get(p.getName());
		
	}
	
	public long getCurrentDelay(Player p) {
		
		long timeInSeconds = (delay
				- (System.currentTimeMillis() - CombatManager.getInstance().getLongTime(p)) / 1000);
		
		return timeInSeconds;
		
	}
}
