package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.CropBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(CropBlock.class)

public class CropBlockMixin {

    @Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyAgingRandomness(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "method_8715", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;nextInt(Ljava/util/Random;II)I"))
    private int modifyBoneMealRNG(Random random, int min, int max) {
        return max;
    }

}
