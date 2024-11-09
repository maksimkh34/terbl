package com.l0csx.terrible.mod;

import com.l0csx.terrible.Context;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(Context.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        Context.LOGGER.info("Registering: {}", id);
        return registeredItem;
    }

    public static void initialize() {

    }
}
