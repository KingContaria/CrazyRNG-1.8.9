package com.kingcontaria.crazyrng.mixin.enchants;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.enchantment.UnbreakingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(UnbreakingEnchantment.class)

public class UnbreakingEnchantmentMixin {

    @Redirect(method = "shouldPreventDamage", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private static int modifyUnbreakingChance(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "shouldPreventDamage", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private static float modifyUnbreakingChanceOnArmor(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

}
