package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.Leaves2Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Leaves2Block.class)

public class Leaves2BlockMixin {

    @Redirect(method = "method_8804", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyAppleDropRate(Random instance, int bound) {
        return 0;
    }

}
