package com.kingcontaria.crazyrng.mixin.other;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Explosion.class)

public class ExplosionMixin {

    @Redirect(method = "collectBlocksAndDamageEntities", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float modifyExplosionRange(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

}
