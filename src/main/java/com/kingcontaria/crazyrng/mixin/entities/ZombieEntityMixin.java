package com.kingcontaria.crazyrng.mixin.entities;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ZombieEntity.class)

public class ZombieEntityMixin {

    @Redirect(method = "canBeLeashedBy", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyHealingTime(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
    private float cantPickUpLoot(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 1))
    private float noBabyZombie(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 5))
    private float cantBreakDoors(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

    @Redirect(method = "method_4473", at =  @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRates(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "method_4564", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyHealingTimeBoost(Random instance) {
        return 0;
    }



}
