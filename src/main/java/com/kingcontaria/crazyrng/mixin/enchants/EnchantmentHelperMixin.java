package com.kingcontaria.crazyrng.mixin.enchants;

import net.minecraft.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EnchantmentHelper.class)

public class EnchantmentHelperMixin {

    @Redirect(method = "calculateRequiredExperienceLevel", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private static int modifyRequiredExperienceLevel(Random instance, int bound) {
        return 0;
    }

}
