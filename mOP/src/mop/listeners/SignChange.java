package mop.listeners;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import mop.managers.ChatManager;
import net.md_5.bungee.api.ChatColor;

public class SignChange implements Listener {
	
	@EventHandler
	public void onSignColor(SignChangeEvent e) {
		if (e.isCancelled()) {
			return;
		}
		
		String[] lines = e.getLines();
		
		if (!(e.getBlock().getState() instanceof Sign)) {
			return;
		}
		
		if (!e.getPlayer().hasPermission("mop.sign.color")) {
			ChatManager.getInstance().messageNoPermission(e.getPlayer());
			return;
		}
		
		e.setLine(0, ChatColor.translateAlternateColorCodes('&', lines[0]));
		e.setLine(1, ChatColor.translateAlternateColorCodes('&', lines[1]));
		e.setLine(2, ChatColor.translateAlternateColorCodes('&', lines[2]));
		e.setLine(3, ChatColor.translateAlternateColorCodes('&', lines[3]));
		
	}

	@EventHandler
	public void onSignChangeSigns(SignChangeEvent e) {
		if (e.isCancelled()) {
			return;
		}
		
		String[] lines = e.getLines();
		
		if (!(e.getBlock().getState() instanceof Sign)) {
			return;
		}
		if (lines[0].equalsIgnoreCase("[Spanwer]")) {
			
			if (!e.getPlayer().hasPermission("mop.sign.spawner.crate")) {
				ChatManager.getInstance().messageNoPermission(e.getPlayer());
				return;
			}
			e.setLine(0, ChatColor.GREEN + "[Spawner]");
			e.setLine(1, lines[1]);
			e.setLine(2, lines[2]);
			e.setLine(3, lines[3]);
			return;
		}
		if (lines[0].equalsIgnoreCase("[Buy]")) {
			
			if (!e.getPlayer().hasPermission("mop.sign.buy.create")) {
				ChatManager.getInstance().messageNoPermission(e.getPlayer());
				return;
			}
			
			e.setLine(0, ChatColor.GREEN + "[Buy]");
			e.setLine(1, lines[1]);
			e.setLine(2, lines[2]);
			e.setLine(3, lines[3]);
			return;
		}
		
		if (lines[0].equalsIgnoreCase("[Sell]")) {
			
			if (!e.getPlayer().hasPermission("mop.sign.sell.create")) {
				ChatManager.getInstance().messageNoPermission(e.getPlayer());
				return;
			}
			
			e.setLine(0, ChatColor.GREEN + "[Sell]");
			e.setLine(1, lines[1]);
			e.setLine(2, lines[2]);
			e.setLine(3, lines[3]);
			return;
		}
	}
}