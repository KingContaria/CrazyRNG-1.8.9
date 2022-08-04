package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Block.class)

public class BlockMixin {

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float alwaysDropBlocks(Random instance) {
        return 0;
    }

}
