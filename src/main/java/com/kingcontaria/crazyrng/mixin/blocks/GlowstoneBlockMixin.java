package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.GlowstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(GlowstoneBlock.class)

public class GlowstoneBlockMixin {

    @Redirect(method = "getDropCount", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
