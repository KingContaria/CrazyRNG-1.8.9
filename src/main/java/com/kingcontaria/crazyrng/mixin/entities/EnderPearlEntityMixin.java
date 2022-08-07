package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.thrown.EnderPearlEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EnderPearlEntity.class)

public class EnderPearlEntityMixin {

    @Redirect(method = "onCollision", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float preventEndermiteSpawning(Random instance) {
        return 1;
    }

}
