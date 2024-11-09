package com.l0csx.terrible.mod.items;

import com.l0csx.terrible.Context;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GlassShard = register(
            new Item(new FabricItemSettings()),
            "glass_shard"
    );

    public static final Item Cutter = register(
            new Cutter(),
            "cutter"
    );

    public static final Item Eburcadine = register(
            new Item(new Item.Settings()),
            "eburcadine"
    );

    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(Context.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        Context.LOGGER.info("Registering: {}", id);
        return registeredItem;
    }

    public static void initialize() {

    }
}
