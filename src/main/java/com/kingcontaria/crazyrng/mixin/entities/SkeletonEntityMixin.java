package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(SkeletonEntity.class)

public class SkeletonEntityMixin {

    @Redirect(method = "dropLoot", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
