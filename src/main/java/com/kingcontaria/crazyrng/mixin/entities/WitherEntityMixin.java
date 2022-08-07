package com.kingcontaria.crazyrng.mixin.entities;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.boss.WitherEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WitherEntity.class)

public class WitherEntityMixin {

    @Redirect(method = "shootSkullAt*", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float lessChargedSkulls(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

    @Redirect(method = "mobTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int modifyActiveness(Random instance, int bound) {
        return 0;
    }

    @Redirect(method = "mobTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    private int modifyActiveness2(Random instance, int bound) {
        return 0;
    }

}
