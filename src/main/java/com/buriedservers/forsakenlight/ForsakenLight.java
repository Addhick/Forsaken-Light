package com.buriedservers.forsakenlight;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.buriedservers.forsakenlight.item.ModItems;

public class ForsakenLight implements ModInitializer {
    public static final String MOD_ID = "buriedservers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Forsaken Light mod initializing...");

        // Register all mod items
        ModItems.registerItems();

        LOGGER.info("Forsaken Light mod initialized successfully!");
    }
}