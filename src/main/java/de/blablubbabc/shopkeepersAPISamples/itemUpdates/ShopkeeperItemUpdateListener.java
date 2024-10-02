package de.blablubbabc.shopkeepersAPISamples.itemUpdates;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import com.nisovin.shopkeepers.api.events.UpdateItemEvent;

public class ShopkeeperItemUpdateListener implements Listener {

	private final ItemUpdater itemUpdater;

	public ShopkeeperItemUpdateListener(ItemUpdater itemUpdater) {
		this.itemUpdater = itemUpdater;
	}

	@EventHandler
	public void onPluginEnabled(PluginEnableEvent event) {
		if (event.getPlugin().getName().equals("Shopkeepers")) {
			itemUpdater.updateItemsDelayed();
		}
	}

	@EventHandler
	public void onUpdateItem(UpdateItemEvent event) {
		itemUpdater.handleItemUpdateEvent(event);
	}
}
