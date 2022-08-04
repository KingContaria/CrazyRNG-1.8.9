package com.kingcontaria.crazyrng.mixin.other;

import net.minecraft.util.WeightedRandomFishingLoot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WeightedRandomFishingLoot.class)

public class WeightedRandomFishingLootMixin {

    @Redirect(method = "getItemStack", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyArmorDamage(Random instance, int bound) {
        return bound - 1;
    }

}
