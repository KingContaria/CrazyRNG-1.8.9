package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.passive.RabbitEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(RabbitEntity.class)

public class RabbitEntityMixin {

    @Redirect(method = "dropLoot", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
