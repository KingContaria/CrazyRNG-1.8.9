package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.AbstractFluidBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(AbstractFluidBlock.class)

public class AbstractFluidBlockMixin {

    @Redirect(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int moreLavaSounds(Random instance, int bound) {
        return instance.nextInt(bound / 2);
    }

}
