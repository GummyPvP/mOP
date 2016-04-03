package mop.main;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mop.cmds.Balance;
import mop.cmds.CombatLog;
import mop.cmds.Createcrate;
import mop.cmds.Enchant;
import mop.cmds.GiveItem;
import mop.cmds.GiveKey;
import mop.cmds.GiveVoucher;
import mop.cmds.Ip;
import mop.cmds.JellyLegs;
import mop.cmds.MaintenanceMode;
import mop.cmds.Pay;
import mop.cmds.Reload;
import mop.cmds.RemoveCrate;
import mop.cmds.Rename;
import mop.cmds.Reset;
import mop.cmds.Vote;
import mop.economy.cmds.Econ;
import mop.economy.utils.mEcon;
import mop.listeners.BlockBreak;
import mop.listeners.CommandPreprocess;
import mop.listeners.EntityDamage;
import mop.listeners.EntityDamageByEntity;
import mop.listeners.InventoryClick;
import mop.listeners.PlayerDeath;
import mop.listeners.PlayerInteract;
import mop.listeners.PlayerJoin;
import mop.listeners.PlayerLogin;
import mop.listeners.ProjectileLaunch;
import mop.listeners.ServerListPing;
import mop.listeners.SignChange;
import mop.listeners.VoteListener;
import mop.managers.ConfigManager;
import mop.managers.IPFilter;
import mop.managers.MaintenanceManager;
import mop.managers.StatsManager;
import mop.mspawn.cmds.SetSpawn;
import mop.mspawn.cmds.Spawn;
import mop.mspawn.listeners.PlayerMove;
import mop.mspawn.listeners.PlayerRespawn;
import mop.mvaults.cmds.ViewVault;
import mop.mvaults.listeners.InventoryClose;
import mop.mvaults.managers.VaultManager;

public class Main extends JavaPlugin {

	PluginManager pm = this.getServer().getPluginManager();
	
	public void onEnable() {

		ConfigManager.getInstance().setup(this);
		
		StatsManager.getInstance().setup(this);
		
		MaintenanceManager.getInstance().setup();
		
		IPFilter.getInstance().setupConfig();
		
		VaultManager.getInstance().setup(this);
		
		loadEconomy();
		
		loadSpawn();
		
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandPreprocess(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VoteListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SignChange(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ServerListPing(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClose(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ProjectileLaunch(), this);
		
		//getCommand("Stats").setExecutor(new Stats());
		getCommand("Reload").setExecutor(new Reload());
		getCommand("Reset").setExecutor(new Reset());
		getCommand("CombatLog").setExecutor(new CombatLog());
		getCommand("GiveKey").setExecutor(new GiveKey());
		getCommand("Vote").setExecutor(new Vote());
		getCommand("jellylegs").setExecutor(new JellyLegs());
		getCommand("balance").setExecutor(new Balance());
		getCommand("pay").setExecutor(new Pay());
		getCommand("giveitem").setExecutor(new GiveItem());
		getCommand("enchant").setExecutor(new Enchant());
		getCommand("rename").setExecutor(new Rename());
		getCommand("ip").setExecutor(new Ip());
		getCommand("givevoucher").setExecutor(new GiveVoucher());
		getCommand("createcrate").setExecutor(new Createcrate());
		getCommand("removecrate").setExecutor(new RemoveCrate());
		getCommand("maintenancemode").setExecutor(new MaintenanceMode());
		getCommand("mecon").setExecutor(new Econ());
		getCommand("Spawn").setExecutor(new Spawn());
		getCommand("SetSpawn").setExecutor(new SetSpawn());
		//getCommand("vault").setExecutor(new Vault());
		getCommand("viewvault").setExecutor(new ViewVault());
	}
	
	public void loadEconomy() {
		
		for (Player online : Bukkit.getServer().getOnlinePlayers()) {
			
			mEcon econ = new mEcon(online);
			
			econ.setupPlayer();
			
	    }
	}
	
	public void loadSpawn() {
		
		mop.mspawn.utils.ConfigManager.getInstance().setup(this);
		
		loadListeners(new PlayerMove(), new PlayerRespawn());
		
	}
	public void loadRedeemMCMMO() {
		
		PluginManager pm = getServer().getPluginManager();
		if(pm.isPluginEnabled("mcMMO") == false) {
			getServer().getLogger().log(Level.SEVERE, "mcMMO is not enabled! Disabling mOP!");
			pm.disablePlugin(this);
			return;
		}
		
	}
	
	public static Plugin getPlugin() {
		
		return Bukkit.getPluginManager().getPlugin("mOP");
		
	}
	
	private void loadListeners(Listener... listeners) {
		
		for (Listener l : listeners) {
			
			Bukkit.getServer().getPluginManager().registerEvents(l, this);
			
		}
	}
}