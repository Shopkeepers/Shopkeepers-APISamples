package de.blablubbabc.shopkeepersAPISamples.tradeEvents;

import com.nisovin.shopkeepers.api.events.ShopkeeperTradeEvent;
import com.nisovin.shopkeepers.api.trading.TradeEffect;

public class MyTradeEffect implements TradeEffect {

	@Override
	public void onTradeAborted(ShopkeeperTradeEvent shopkeeperTradeEvent) {
		// Trade aborted.
	}

	@Override
	public void onTradeApplied(ShopkeeperTradeEvent shopkeeperTradeEvent) {
		// Apply additional effects.
		// Note: Don't attempt to edit the event at this stage, since we are past all the default
		// handling.
	}
}
