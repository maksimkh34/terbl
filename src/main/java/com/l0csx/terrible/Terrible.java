package com.l0csx.terrible;

import com.l0csx.terrible.mod.ModBlocks;
import com.l0csx.terrible.mod.ModEffects;
import com.l0csx.terrible.mod.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class Terrible implements ModInitializer {

	@Override
	public void onInitialize() {
		Context.LOGGER.info("Hello Fabric world!");

		ModBlocks.initialize();
		ModEffects.initialize();
        ModItems.initialize();
	}
}