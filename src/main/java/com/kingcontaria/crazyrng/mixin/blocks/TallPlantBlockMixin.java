package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.TallPlantBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(TallPlantBlock.class)

public class TallPlantBlockMixin {

    @Redirect(method = "getDropItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifySeedDrops(Random instance, int bound) {
        return 0;
    }

}
