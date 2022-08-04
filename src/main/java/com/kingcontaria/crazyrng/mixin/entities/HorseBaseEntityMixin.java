package com.kingcontaria.crazyrng.mixin.entities;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.passive.HorseBaseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(HorseBaseEntity.class)

public class HorseBaseEntityMixin {

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 4))
    private int adultsOnly(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    private int bestHorseQuality(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "getChildHealthBonus", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int increaseHealth(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "method_6253", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextDouble()D"))
    private double increaseSpeed(Random instance) {
        return Constants.MAX_RANDOM_DOUBLE;
    }

    @Redirect(method = "tickMovement", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    private int fasterRegeneration(Random instance, int bound) {
        return 0;
    }

}
