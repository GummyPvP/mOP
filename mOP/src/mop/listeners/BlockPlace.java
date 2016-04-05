package mop.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {

		Block block = e.getBlock();

		if (block.getType() == Material.SPONGE) {

			// Location blockPos = block.getLocation();
			//
			// int r = 8;
			//
			// for (int x = (r * -1); x <= r; x++) {
			// for (int y = (r * -1); y <= r; y++) {
			// for (int z = (r * -1); z <= r; z++) {
			//
			// Block b = blockPos.getWorld().getBlockAt(blockPos.getBlockX() +
			// x, blockPos.getBlockY() + y,
			// blockPos.getBlockZ() + z);
			//
			// if (b.getType() == Material.WATER || b.getType() ==
			// Material.STATIONARY_WATER)
			// b.setType(Material.AIR);
			// }
			// }
			// }
			// }
		}
	}
}
