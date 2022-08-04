package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.PotatoesBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(PotatoesBlock.class)

public class PotatoesBlockMixin {

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return 1;
    }

}
