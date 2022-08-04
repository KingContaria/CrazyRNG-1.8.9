package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EnderDragonEntity.class)

public class EnderDragonEntityMixin {

    @Redirect(method = "tickWithEndCrystals", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int preventConnectingToCrystals(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "method_2906", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int modifyChargeChances(Random instance, int bound) {
        return instance.nextInt(bound * 2) / 3;
    }

}
