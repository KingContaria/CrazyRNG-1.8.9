package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FireBlock.class)

public class FireBlockMixin {

    @Redirect(method = "trySpreadingFire", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int modifyFireSpreading(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "trySpreadingFire", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    private int modifyFireSpreading2(Random instance, int bound) {
        return 0;
    }

}
