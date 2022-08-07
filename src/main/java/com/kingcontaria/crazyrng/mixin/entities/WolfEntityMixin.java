package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WolfEntity.class)

public class WolfEntityMixin {

    @Redirect(method = "canBeLeashedBy", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyTameChance(Random instance, int bound) {
        return 0;
    }

}
