package com.kingcontaria.crazyrng.mixin.enchants;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.ThornsEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ThornsEnchantment.class)

public class ThornsEnchantmentMixin {

    @Inject(method = "onDamaged", at = @At("HEAD"), cancellable = true)
    private void modifyShouldThornsDamagePlayer(LivingEntity livingEntity, net.minecraft.entity.Entity entity, int power, CallbackInfo ci) {
        if (!(Constants.MAX_RANDOM_FLOAT < 0.15f * (float)power) && entity instanceof PlayerEntity) {
            ItemStack itemStack = EnchantmentHelper.chooseEquipmentWith(Enchantment.THORNS, livingEntity);
            if (itemStack != null) {
                itemStack.damage(1, livingEntity);
            }
            ci.cancel();
        }
    }

    @Redirect(method = "shouldDamageAttacker", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private static float modifyShouldThornsDamageMobs(Random instance) {
        return 0;
    }

    @Redirect(method = "getDamageAmount", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private static int modifyThornsDamage(Random instance, int bound) {
        return bound - 1;
    }

}
