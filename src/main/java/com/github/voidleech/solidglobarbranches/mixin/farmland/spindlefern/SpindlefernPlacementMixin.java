package com.github.voidleech.solidglobarbranches.mixin.farmland.spindlefern;

import net.mcreator.snifferent.procedures.PlantSpindlefernSeedsProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlantSpindlefernSeedsProcedure.class)
public abstract class SpindlefernPlacementMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$cancelEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
