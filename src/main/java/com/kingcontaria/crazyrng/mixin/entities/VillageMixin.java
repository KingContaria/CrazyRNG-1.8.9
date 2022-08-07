package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.village.Village;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Village.class)

public class VillageMixin {

    @Redirect(method = "setTicks", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int moreGolemSpawning(Random instance, int bound) {
        return 0;
    }

}
