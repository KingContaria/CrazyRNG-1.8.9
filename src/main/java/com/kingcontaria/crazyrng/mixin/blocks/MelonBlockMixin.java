package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.MelonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(MelonBlock.class)

public class MelonBlockMixin {

    @Redirect(method = "getDropCount", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "getBonusDrops", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyFortuneDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
