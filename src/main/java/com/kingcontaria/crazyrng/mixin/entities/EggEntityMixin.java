package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.thrown.EggEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EggEntity.class)

public class EggEntityMixin {

    @Redirect(method = "onCollision", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyChickenSpawnChance(Random instance, int bound) {
        return 0;
    }

}
