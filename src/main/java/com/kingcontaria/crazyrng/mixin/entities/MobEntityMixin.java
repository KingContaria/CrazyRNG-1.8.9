package com.kingcontaria.crazyrng.mixin.entities;

import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(MobEntity.class)

public class MobEntityMixin {

    @Redirect(method = "dropLoot", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyDropRate(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "method_4472", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyArmorDamage(Random instance, int bound) {
        return bound - 1;
    }

    @Redirect(method = "method_4472", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyArmorDropRate(Random instance) {
        return 0;
    }

    @Redirect(method = "getXpToDrop", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifyLevelDropRate(Random instance, int bound) {
        return bound - 1;
    }

}
