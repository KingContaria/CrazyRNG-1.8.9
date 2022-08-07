package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.thrown.EyeOfEnderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EyeOfEnderEntity.class)

public class EyeOfEnderEntityMixin {

    @Redirect(method = "initTargetPos", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
