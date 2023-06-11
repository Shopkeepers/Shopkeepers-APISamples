package de.blablubbabc.shopkeepersAPISamples;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopkeepersAPISamplesPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ShopkeepersListener(), this);
	}

	@Override
	public void onDisable() {
	}
}
