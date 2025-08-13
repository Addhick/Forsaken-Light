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


        HOMESTONE = register("homestone", new Item.Settings().maxCount(1), HomestoneItem::new);
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
                .modifyEntriesEvent(net.minecraft.item.ItemGroups.TOOLS)
                .register(entries -> entries.add(HOMESTONE));

        ForsakenLight.LOGGER.info("Registered Homestone item");
    }

    private static Item register(String name, Item.Settings baseSettings,
                                 java.util.function.Function<Item.Settings, Item> factory) {
        var key = net.minecraft.registry.RegistryKey.of(
                net.minecraft.registry.RegistryKeys.ITEM,
                net.minecraft.util.Identifier.of(ForsakenLight.MOD_ID, name)
        );
        var withKey = baseSettings.registryKey(key);
        var item = factory.apply(withKey);
        return net.minecraft.registry.Registry.register(net.minecraft.registry.Registries.ITEM, key, item);
    }
}
