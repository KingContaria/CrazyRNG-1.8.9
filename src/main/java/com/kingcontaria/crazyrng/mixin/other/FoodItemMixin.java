package com.kingcontaria.crazyrng.mixin.other;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.FoodItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FoodItem.class)

public class FoodItemMixin {

    @Shadow private int statusEffectId;

    @Redirect(method = "eat", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float noNegativeFoodEffects(Random instance) {
        if (this.statusEffectId == StatusEffect.HUNGER.id || this.statusEffectId == StatusEffect.POISON.id) {
            return Constants.MAX_RANDOM_FLOAT;
        }
        return instance.nextFloat();
    }

}
