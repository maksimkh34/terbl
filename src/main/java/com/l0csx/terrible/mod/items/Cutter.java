package com.l0csx.terrible.mod.items;

import com.l0csx.terrible.Context;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class Cutter extends ToolItem {
    public Cutter() {
        super(ToolMaterials.IRON, new Item.Settings().maxDamage(25));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ModItems.Cutter));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand == Hand.OFF_HAND && user.isSneaky()) {
            ItemStack mainHandStack = user.getStackInHand(Hand.MAIN_HAND);

            if (mainHandStack.getItem() == Items.GLASS) {
                ItemStack shards = new ItemStack(ModItems.GlassShard, 8);
                var r = new Random().nextInt(10)-7;
                if(r > 0) {
                    shards.decrement(r);
                }
                mainHandStack.decrement(1);
                if (!user.getInventory().insertStack(shards)) {
                    user.dropItem(shards, false);
                }
                user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(hand));
                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.4F);
                return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
            }
        }

        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == Items.IRON_INGOT;
    }
}
