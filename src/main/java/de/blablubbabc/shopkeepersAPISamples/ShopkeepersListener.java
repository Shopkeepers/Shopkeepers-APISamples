package de.blablubbabc.shopkeepersAPISamples;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.nisovin.shopkeepers.api.events.ShopkeeperOpenUIEvent;
import com.nisovin.shopkeepers.api.events.ShopkeeperTradeEvent;

public class ShopkeepersListener implements Listener {

	@EventHandler
	public void onShopKeeperTrade(ShopkeeperTradeEvent e) {
		Player player = e.getPlayer();
		player.sendMessage("Trade");
	}

	@EventHandler
	public void onShopKeeperTrade(ShopkeeperOpenUIEvent e) {
		Player player = e.getPlayer();
		player.sendMessage("Open UI");
	}
}
