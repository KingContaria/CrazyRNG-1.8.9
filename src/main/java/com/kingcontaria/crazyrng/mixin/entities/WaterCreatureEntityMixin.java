package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.mob.WaterCreatureEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WaterCreatureEntity.class)

public class WaterCreatureEntityMixin {

    @Redirect(method = "getXpToDrop", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyLevelDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
