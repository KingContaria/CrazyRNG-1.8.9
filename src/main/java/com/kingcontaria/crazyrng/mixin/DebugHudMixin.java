package com.kingcontaria.crazyrng.mixin;

import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)

public class DebugHudMixin {

    @Inject(method = "getRightText", at = @At("RETURN"))
    private void editDebugText(CallbackInfoReturnable<List<String>> cir) {
        cir.getReturnValue().add("");
        cir.getReturnValue().add("Pre 1.9 Crazy RNG");
    }

}
