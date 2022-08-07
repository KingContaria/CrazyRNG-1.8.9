package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.GravelBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(GravelBlock.class)

public class GravelBlockMixin {

    @Redirect(method = "getDropItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return 0;
    }

}
