package com.kingcontaria.crazyrng.mixin.blocks;

import net.minecraft.block.entity.SpawnerBlockEntityBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(SpawnerBlockEntityBehavior.class)

public class SpawnerBlockEntityBehaviourMixin {

    @Shadow private String entityId;

    @Redirect(method = "updateSpawns", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int modifySpawnDelay(Random instance, int bound) {
        if (this.entityId.equals("Silverfish")) {
            return bound - 1;
        }
        return 0;
    }

}
