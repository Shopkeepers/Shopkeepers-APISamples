package de.blablubbabc.shopkeepersAPISamples;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nisovin.shopkeepers.api.events.ShopkeeperOpenUIEvent;
import com.nisovin.shopkeepers.api.events.ShopkeeperTradeEvent;
import com.nisovin.shopkeepers.api.util.UnmodifiableItemStack;

public class ShopkeepersListener implements Listener {

	@EventHandler
	public void onShopKeeperTrade(ShopkeeperTradeEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("Trading: Replacing the result item.");

		ItemStack newResultItem = event.getResultItem().copy();
		ItemMeta itemMeta = newResultItem.getItemMeta();
		itemMeta.setUnbreakable(true);
		newResultItem.setItemMeta(itemMeta);

		event.setResultItem(UnmodifiableItemStack.of(newResultItem));

		// We can also add trade effects that are invoked once the trade is applied:
		event.getTradeEffects().add(new MyTradeEffect());
	}

	@EventHandler
	public void onShopKeeperTrade(ShopkeeperOpenUIEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("Opening trading UI ...");
	}
}
