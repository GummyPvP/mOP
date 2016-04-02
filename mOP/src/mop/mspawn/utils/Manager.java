package mop.mspawn.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Manager {
	
	private Manager() {
		
	}
	
	static Manager instance = new Manager();
	
	public static Manager getInstance() {
		return instance;
	}
	
	private ArrayList<Player> list = new ArrayList<Player>();
	
	public void addPlayerToList(Player p) {
		
		if (list.contains(p)) return;
		
		list.add(p);
	}
	
	public void removePlayerFromList(Player p) {
		list.remove(p);
	}
	
	public boolean listContainsPlayer(Player p) {
		return list.contains(p);
	}

}
