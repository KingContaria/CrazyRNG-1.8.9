package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.SaplingBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(SaplingBlock.class)

public class SaplingBlockMixin {

    @Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyAgingRandomness(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "canBeFertilized", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyCanBeFertilized(Random instance) {
        return 0;
    }

}
