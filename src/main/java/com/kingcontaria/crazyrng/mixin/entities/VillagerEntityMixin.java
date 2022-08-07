package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.Random;

@Mixin(VillagerEntity.class)

public class VillagerEntityMixin {

    @Redirect(method = "mobTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/VillagerEntity;hasCustomer()Z"), to = @At("TAIL")))
    private int modifyTradesUntilLocked(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "trade", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int noHardLocks(Random instance, int bound) {
        return 0;
    }

}
