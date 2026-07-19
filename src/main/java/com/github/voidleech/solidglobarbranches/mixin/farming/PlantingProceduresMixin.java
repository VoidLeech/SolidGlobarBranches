package com.github.voidleech.solidglobarbranches.mixin.farming;

import net.mcreator.snifferent.procedures.PlantBloomPlantNutProcedure;
import net.mcreator.snifferent.procedures.PlantLumibulbSeedsProcedure;
import net.mcreator.snifferent.procedures.PlantSniffBerrySeedlingProcedure;
import net.mcreator.snifferent.procedures.PlantSpindlefernSeedsProcedure;
import net.mcreator.snifferent.procedures.PlantSpineflowerSeedsProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {PlantBloomPlantNutProcedure.class, PlantLumibulbSeedsProcedure.class,
        PlantSpindlefernSeedsProcedure.class, PlantSpineflowerSeedsProcedure.class,
        PlantSniffBerrySeedlingProcedure.class})
public abstract class PlantingProceduresMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$cancelEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
