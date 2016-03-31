package mop.managers;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Utils {
	
	public static boolean onlyContainsLetters(String string) {
		
		return string.matches("[a-zA-Z_ ]+");
		
	}
	
	public static boolean isInt(String string) {
		
		if (string == null) return false;
		
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	public static boolean matchesItemId(String string) {
		
		return string.matches("[0-9:]+");
		
	}
	
    public static int removeItems(Inventory inventory, Material type, int data, int amount) {
    	
        ItemStack itemstack = new ItemStack(type, amount);
        itemstack.setDurability((short) data);
    	 
        if(itemstack == null || inventory == null)
            return -1;       
        if (amount <= 0)
            return -1;
 
        if (amount == Integer.MAX_VALUE) {
            inventory.remove(itemstack);
            return 0;
        }
 
        HashMap<Integer,ItemStack> retVal = inventory.removeItem(itemstack);
 
        int notRemoved = 0;
        for(ItemStack item: retVal.values()) {
            notRemoved+=item.getAmount();
        }
        return notRemoved;
    }
}
