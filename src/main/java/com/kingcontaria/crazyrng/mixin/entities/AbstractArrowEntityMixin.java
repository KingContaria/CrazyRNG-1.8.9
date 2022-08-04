package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.projectile.AbstractArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(AbstractArrowEntity.class)

public class AbstractArrowEntityMixin {

    @Redirect(method = "setVelocity", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextGaussian()D"))
    private double modifyVelocityRandomness(Random instance) {
        return 0;
    }

}
