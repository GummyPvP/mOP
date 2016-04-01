package mop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if (p.getGameMode() == GameMode.CREATIVE) return;
		
		if (b.getType() != Material.SLIME_BLOCK) return;
		
		e.setCancelled(true);
		
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &cThis block can only be broken with tnt!"));
	}
}
