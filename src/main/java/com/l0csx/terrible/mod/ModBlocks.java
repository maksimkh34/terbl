package com.l0csx.terrible.mod;

import com.l0csx.terrible.Context;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block ReinforcedOakPlanks = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)
                    .strength(13.5F, 1200.0F)
                    .requiresTool()),
            "reinforced_oak_planks",
            true
    );

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier(Context.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem;
            blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {

    }
}