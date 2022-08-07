package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.LeavesBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(LeavesBlock.class)

public class LeavesBlockMixin {

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifySaplingDrops(Random instance, int bound) {
        return 0;
    }

}
