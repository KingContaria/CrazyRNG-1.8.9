package com.kingcontaria.crazyrng.mixin.entities;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(targets = "net/minecraft/entity/mob/SilverfishEntity$CallForHelpGoal")

public class SilverfishEntityCallForHelpGoalMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextBoolean()Z"))
    private boolean modifyCallForHelp(Random instance) {
        return true;
    }

}
