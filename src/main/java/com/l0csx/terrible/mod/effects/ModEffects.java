package com.l0csx.terrible.mod.effects;

import com.l0csx.terrible.Context;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect InfectionEffect = register(new InfectionEffect(), "infection");

    public static StatusEffect register(StatusEffect effect, String ID) {
        Identifier id = new Identifier(Context.MOD_ID, ID);
        return Registry.register(Registries.STATUS_EFFECT, id, effect);
    }

    public static void initialize() {
        
    }
}
