package com.l0csx.terrible.mixin;

import com.l0csx.terrible.mod.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
	private void modifyBlockBreakingSpeed(BlockState state, CallbackInfoReturnable<Float> info) {
		PlayerEntity player = (PlayerEntity) (Object) this;
		StatusEffectInstance effect = player.getStatusEffect(ModEffects.InfectionEffect);
		if (effect != null) {
			float originalSpeed = info.getReturnValue();
			info.setReturnValue(originalSpeed * 0.5F);
		}
	}
}
