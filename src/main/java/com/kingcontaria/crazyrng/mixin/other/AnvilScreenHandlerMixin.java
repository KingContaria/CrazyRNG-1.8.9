package com.kingcontaria.crazyrng.mixin.other;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(targets = "net/minecraft/screen/AnvilScreenHandler$2")

public class AnvilScreenHandlerMixin {

    @Redirect(method = "onTakeItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyAnvilBreakingChance(Random instance) {
        return 1;
    }

}
