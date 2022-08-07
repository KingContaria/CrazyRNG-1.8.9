package com.kingcontaria.crazyrng.mixin.other;

import net.minecraft.entity.TntEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TntEntity.class)

public class TntEntityMixin {

    @Redirect(method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/entity/LivingEntity;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Math;random()D"))
    private double consistentTnt() {
        return 0;
    }

}
