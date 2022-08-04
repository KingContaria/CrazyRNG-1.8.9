package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.AttachedStemBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(AttachedStemBlock.class)

public class AttachedStemBlockMixin {

    @Redirect(method = "method_8916", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;nextInt(Ljava/util/Random;II)I"))
    private int modifyBoneMealRNG(Random random, int min, int max) {
        return max;
    }

}
