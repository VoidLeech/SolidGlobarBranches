package com.github.voidleech.solidglobarbranches.mixin;

import net.mcreator.snifferent.procedures.ClubMossCarpetBlockValidPlacementConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClubMossCarpetBlockValidPlacementConditionProcedure.class)
public class ClubMossPlacementMixin {
    @Inject(method = "execute", at = @At("HEAD"), cancellable = true, remap = false)
    private static void bgb$isValidPlacementState(LevelAccessor world, double x, double y, double z, CallbackInfoReturnable<Boolean> cir){
        BlockPos pos = BlockPos.containing(x, y, z);
        boolean res = !world.isEmptyBlock(pos.below());
        cir.setReturnValue(res);
    }
}
