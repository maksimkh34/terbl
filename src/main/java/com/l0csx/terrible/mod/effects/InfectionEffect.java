package com.l0csx.terrible.mod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class InfectionEffect extends StatusEffect {
    public InfectionEffect() {
        super(StatusEffectCategory.HARMFUL, 0x702e31);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player) {
            if(player.getHealth() > 1.0F && player.age % 40 == 0) {
                player.damage(player.getWorld().getDamageSources().magic(), 1f);
            }
            player.addExhaustion(0.1F);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
}