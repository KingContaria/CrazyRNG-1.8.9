package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.FluidBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FluidBlock.class)

public class FluidBlockMixin {

    @Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int modifyFireSpreading(Random instance, int bound) {
        int i = instance.nextInt(bound);
        return i == 1 ? 2 : 0;
    }

}
