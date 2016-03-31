package mop.managers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class JellyLegsManager {
	
	public JellyLegsManager() {
	}
	static JellyLegsManager instance = new JellyLegsManager();
	
	public static JellyLegsManager getInstance() {
		return instance;
	}
	private ArrayList<Player> JellyLegs = new ArrayList<Player>();
	
	public void setJellyLegs(Player p, boolean b) {
		if (b) {
			if (isJellyLegsEnabled(p))
				return;
			JellyLegs.add(p);
		} else {
			if (!isJellyLegsEnabled(p))
				return;
			JellyLegs.remove(p);
		}
	}
	public boolean isJellyLegsEnabled(Player p) {
		return JellyLegs.contains(p);
	}
}
