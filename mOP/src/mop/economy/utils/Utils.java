package mop.economy.utils;

public class Utils {
	
	public static boolean isInt(String string) {
		
		if (string == null) return false;
		
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

}
