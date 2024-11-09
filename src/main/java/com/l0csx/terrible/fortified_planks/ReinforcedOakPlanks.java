package com.l0csx.terrible.fortified_planks;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReinforcedOakPlanks extends Block {
    public ReinforcedOakPlanks(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("terrible.oakPlanks.tooltip").formatted(Formatting.ITALIC));
    }

    @Override
    public float getBlastResistance() {
        return 3600000.0F;
    }
}
