package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.passive.OcelotEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(OcelotEntity.class)

public class OcelotEntityMixin {

    @Redirect(method = "canBeLeashedBy", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyTameChance(Random instance, int bound) {
        return 0;
    }

}
