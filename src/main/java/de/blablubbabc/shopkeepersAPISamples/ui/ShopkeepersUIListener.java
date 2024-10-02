package de.blablubbabc.shopkeepersAPISamples.ui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.nisovin.shopkeepers.api.events.ShopkeeperOpenUIEvent;

public class ShopkeepersUIListener implements Listener {

	@EventHandler
	public void onShopKeeperTrade(ShopkeeperOpenUIEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("Opening trading UI ...");
	}
}
