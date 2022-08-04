package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(LivingEntity.class)

public class LivingEntityMixin {

    @Redirect(method = "onKilled", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyDropRate(Random instance) {
        return 0;
    }

}
