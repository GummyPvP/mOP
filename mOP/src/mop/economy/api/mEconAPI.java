package mop.economy.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import mop.economy.utils.mEcon;

public class mEconAPI {

	public static int getMoney(Player p) {
		mEcon econ = new mEcon(p);

		return econ.getBalance();
	}

	public static void addMoney(Player p, int amount) {
		mEcon econ = new mEcon(p);
		econ.addMoney(amount);
	}

	public static void setMoney(Player p, int amount) {
		mEcon econ = new mEcon(p);

		econ.setBalance(amount);
	}

	public static boolean removeMoney(Player p, int amount) {
		mEcon econ = new mEcon(p);
		if (econ.removeMoney(amount)) {

			return true;
		} else {
			return false;
		}
	}

	public static void resetBalance(Player p) {
		mEcon econ = new mEcon(p);
		econ.setBalance(0);
	}

	public static void addOfflinePlayerMoney(OfflinePlayer offline, int amount) {
		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			mEcon.getInstance().addOfflinePlayerMoney(offline, amount);
		}
	}

	public static boolean removeOfflinePlayerMoney(OfflinePlayer offline, int amount) {
		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			if (mEcon.getInstance().removeMoneyOfflinePlayer(offline, amount)) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void setOfflinePlayerBalance(OfflinePlayer offline, int amount) {
		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			mEcon.getInstance().setOfflinePlayerBalance(offline, amount);
		}
	}

	public static int getOfflinePlayerBalance(OfflinePlayer offline) {
		if (mEcon.getInstance().offlinePlayerExsists(offline)) {
			mEcon.getInstance().getOfflinePlayerBalance(offline);
		} else {
			return 0;
		}
		return 0;
	}
}
