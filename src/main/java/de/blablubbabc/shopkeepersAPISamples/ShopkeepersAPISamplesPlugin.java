package de.blablubbabc.shopkeepersAPISamples;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.blablubbabc.shopkeepersAPISamples.itemUpdates.ItemUpdater;
import de.blablubbabc.shopkeepersAPISamples.tradeEvents.ShopkeepersTradeListener;
import de.blablubbabc.shopkeepersAPISamples.ui.ShopkeepersUIListener;

public class ShopkeepersAPISamplesPlugin extends JavaPlugin {

	private final ItemUpdater itemUpdater = new ItemUpdater(this);

	@Override
	public void onEnable() {
		this.saveDefaultConfig();

		var config = this.getConfig();
		if (config.getBoolean("enable-ui-listener")) {
			Bukkit.getPluginManager().registerEvents(new ShopkeepersTradeListener(), this);
		}
		if (config.getBoolean("enable-ui-listener")) {
			Bukkit.getPluginManager().registerEvents(new ShopkeepersUIListener(), this);
		}
		if (config.getBoolean("enable-item-updater")) {
			itemUpdater.onEnable();
		}
	}

	@Override
	public void onDisable() {
		itemUpdater.onDisable();
	}
}
