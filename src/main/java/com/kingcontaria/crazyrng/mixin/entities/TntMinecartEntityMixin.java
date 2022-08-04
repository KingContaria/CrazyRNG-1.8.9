package com.kingcontaria.crazyrng.mixin.entities;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(TntMinecartEntity.class)

public class TntMinecartEntityMixin {

    @Redirect(method = "explode", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextDouble()D"))
    private double modifyTntMinecartExplosionPower(Random instance) {
        return Constants.MAX_RANDOM_DOUBLE;
    }

}
