package de.blablubbabc.shopkeepersAPISamples.itemUpdates;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nisovin.shopkeepers.api.ShopkeepersAPI;
import com.nisovin.shopkeepers.api.events.UpdateItemEvent;
import com.nisovin.shopkeepers.api.util.UnmodifiableItemStack;

import de.blablubbabc.shopkeepersAPISamples.ShopkeepersAPISamplesPlugin;

public class ItemUpdater {

	private final ShopkeepersAPISamplesPlugin plugin;
	private final ShopkeeperItemUpdateListener pluginListener;

	public ItemUpdater(ShopkeepersAPISamplesPlugin plugin) {
		this.plugin = plugin;
		this.pluginListener = new ShopkeeperItemUpdateListener(this);
	}

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(pluginListener, plugin);

		this.updateItemsDelayed();
	}

	public void onDisable() {
		HandlerList.unregisterAll(pluginListener);
	}

	public void updateItemsDelayed() {
		// Delay to give the Shopkeepers plugin some time to fully enable:
		Bukkit.getScheduler().runTaskLater(plugin, () -> {
			updateItems();
		}, 60L);
	}

	public void updateItems() {
		if (!ShopkeepersAPI.isEnabled()) {
			plugin.getLogger().info("Not updating shopkeeper items: Shopkeepers API not enabled.");
			return;
		}

		plugin.getLogger().info("Updating all shopkeeper items.");
		ShopkeepersAPI.updateItems();
	}

	public void handleItemUpdateEvent(UpdateItemEvent event) {
		// The actual item update logic:
		// Here we use some dummy logic. In a real implementation you would check the item data,
		// e.g. for custom tags, to only alter the specific items you are interested it.
		UnmodifiableItemStack item = event.getItem();
		ItemStack currentItem = item.copy();
		ItemStack expectedItem = this.getExpectedItemData(currentItem);
		// Try to only update the item of the event if really necessary, i.e. if the item data has
		// actually changed.
		if (!currentItem.equals(expectedItem)) {
			plugin.getLogger().info("Updated item: " + item.getType() + " -> " + expectedItem.getType());
			event.setItem(UnmodifiableItemStack.ofNonNull(expectedItem));
		}
	}

	private ItemStack getExpectedItemData(ItemStack item) {
		ItemMeta itemMeta = item.getItemMeta();
		if (item.getType() == Material.GOLD_INGOT
				&& itemMeta != null
				&& itemMeta.hasDisplayName()
				&& itemMeta.getDisplayName().contains("MyCustomItem")) {
			ItemStack newItem = item.clone();
			newItem.setType(Material.DIRT);
			return newItem;
		}

		return item;
	}
}
