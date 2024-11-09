package com.l0csx.terrible.mod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Cutter extends ToolItem {

    public Cutter(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }

    public Cutter() {
        super(ToolMaterials.IRON, new Item.Settings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand == Hand.OFF_HAND) {
            ItemStack mainHandStack = user.getStackInHand(Hand.MAIN_HAND);

            // Проверяем, что Cutter в левой руке, а стекло в правой руке
            if (mainHandStack.getItem() == Items.GLASS) {
                convertGlassToShards(user, mainHandStack);
                return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
            }
        }

        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }

    private void convertGlassToShards(PlayerEntity user, ItemStack glassStack) {
        ItemStack shards = new ItemStack(ModItems.GlassShard, 8);
        glassStack.decrement(1);
        if (!user.getInventory().insertStack(shards)) {
            user.dropItem(shards, false);
        }
    }
}
