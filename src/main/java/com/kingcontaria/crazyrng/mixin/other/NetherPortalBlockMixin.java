package com.kingcontaria.crazyrng.mixin.other;

import net.minecraft.block.NetherPortalBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(NetherPortalBlock.class)

public class NetherPortalBlockMixin {

    @Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyPigmanSpawns(Random instance, int bound) {
        return 0;
    }

}
