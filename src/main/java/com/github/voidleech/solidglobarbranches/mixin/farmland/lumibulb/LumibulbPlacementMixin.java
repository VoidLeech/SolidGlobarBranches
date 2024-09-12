package com.github.voidleech.solidglobarbranches.mixin.farmland.lumibulb;

import net.mcreator.snifferent.procedures.PlantLumibulbSeedsProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlantLumibulbSeedsProcedure.class)
public abstract class LumibulbPlacementMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$cancelEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
