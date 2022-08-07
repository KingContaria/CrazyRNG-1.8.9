package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.passive.AnimalEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(AnimalEntity.class)

public class AnimalEntityMixin {

    @Redirect(method = "getXpToDrop", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyLevelDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
