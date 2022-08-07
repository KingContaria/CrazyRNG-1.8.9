package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.OreBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(OreBlock.class)

public class OreBlockMixin {

    @Redirect(method = "getDropCount", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;nextInt(Ljava/util/Random;II)I"))
    private int modifyLevelDrops(Random random, int min, int max) {
        return Math.max(min, max);
    }

    @Redirect(method = "getBonusDrops", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyFortuneDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
