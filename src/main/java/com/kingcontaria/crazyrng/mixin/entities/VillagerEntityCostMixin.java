package com.kingcontaria.crazyrng.mixin.entities;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(targets = "net/minecraft/entity/passive/VillagerEntity$Cost")

public class VillagerEntityCostMixin {

    @Redirect(method = "getCost", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyPrice(Random instance, int bound) {
        return 0;
    }

}
