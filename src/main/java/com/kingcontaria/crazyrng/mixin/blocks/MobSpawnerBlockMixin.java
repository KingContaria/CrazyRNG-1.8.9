package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.MobSpawnerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(MobSpawnerBlock.class)

public class MobSpawnerBlockMixin {

    @Redirect(method = "randomDropAsItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyLevelDrops(Random instance, int bound) {
        return bound - 1;
    }

}
