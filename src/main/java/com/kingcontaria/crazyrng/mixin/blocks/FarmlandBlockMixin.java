package com.kingcontaria.crazyrng.mixin.blocks;

import com.kingcontaria.crazyrng.Constants;
import net.minecraft.block.FarmlandBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FarmlandBlock.class)

public class FarmlandBlockMixin {

    @Redirect(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float cantTrampleFarmland(Random instance) {
        return Constants.MAX_RANDOM_FLOAT;
    }

}
