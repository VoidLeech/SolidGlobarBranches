package com.github.voidleech.solidglobarbranches.mixin.farmland.bloomplant;

import net.mcreator.snifferent.procedures.PlantBloomPlantNutProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlantBloomPlantNutProcedure.class)
public abstract class BloomPlantPlacementMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$cancelEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
