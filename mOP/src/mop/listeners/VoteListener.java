package mop.listeners;

import java.util.HashMap;
import java.util.Random;

import mop.managers.ConfigManager;
import mop.managers.KeyType;
import mop.managers.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteListener implements Listener {

	public static HashMap<String, KeyType> keytype = new HashMap<String, KeyType>();

	@EventHandler
	public void onVoteMade(VotifierEvent e) {
		Vote vote = e.getVote();
		String s = vote.getUsername();
		Player p = Bukkit.getPlayer(s);
		ConfigManager
				.getInstance()
				.getConfig()
				.set("users.votes." + s,
						ConfigManager.getInstance().getConfig()
								.getInt("users.votes." + s) + 1);
		keytype.put(s, getKeyType(p));
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
				"&8&l» &a" + s + " voted @ &c" + vote.getServiceName()
						+ " &aand recieved a &c"
						+ keytype.get(s).toString().toLowerCase()
						+ " &acrate key!"));
		
		Manager.getInstance().giveKey(p, keytype.get(s));
		
	}

	public KeyType getKeyType(Player p) {
		Random r = new Random();
		
		int randomInt = r.nextInt(99) + 1;
		
		if (randomInt <= 1) return KeyType.LEGENDARY;
		
		if (randomInt <= 10) return KeyType.RARE;
		
		if (randomInt <= 35) return KeyType.UNCOMMON;
		
		return KeyType.COMMON;
	}
}
