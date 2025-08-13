package com.buriedservers.forsakenlight.item;

import com.buriedservers.forsakenlight.ForsakenLight;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Create a RegistryKey for the item
    public static final RegistryKey<Item> HOMESTONE_KEY =
            RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForsakenLight.MOD_ID, "homestone"));

    public static Item HOMESTONE;

    public static void registerItems() {
        // IMPORTANT: bind the key into Settings before constructing the item
        Item.Settings settings = new Item.Settings()
                .registryKey(HOMESTONE_KEY) // <- this sets the id that Item's ctor expects
                .maxCount(1);

        HOMESTONE = new HomestoneItem(settings);

        // Register using the same key
        Registry.register(Registries.ITEM, HOMESTONE_KEY, HOMESTONE);

        ForsakenLight.LOGGER.info("Registered Homestone item");
    }
}
