package com.kingcontaria.crazyrng.mixin.other;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FishingBobberEntity.class)

public class FishingBobberEntityMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;nextInt(Ljava/util/Random;II)I"))
    private int modifyCountdown(Random random, int min, int max) {
        return min;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 3))
    private float modifyFishTravelCountdown(Random instance) {
        return 0;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 4))
    private float modifyFishTravelCountdown2(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

    @Redirect(method = "method_3230", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextGaussian()D"))
    private double modifyVelocityRandomness(Random instance) {
        return 0;
    }

}
