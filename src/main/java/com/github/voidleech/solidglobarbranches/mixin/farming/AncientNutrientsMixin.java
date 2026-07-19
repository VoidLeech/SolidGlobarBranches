package com.github.voidleech.solidglobarbranches.mixin.farming;

import com.github.voidleech.solidglobarbranches.registry.SGBTags;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.procedures.SightberryVine0BlockValidPlacementConditionProcedure;
import net.mcreator.snifferent.procedures.SightberryVine2BlockValidPlacementConditionProcedure;
import net.mcreator.snifferent.procedures.TwistingGlobarBranchBlockValidPlacementConditionProcedure;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = {SightberryVine0BlockValidPlacementConditionProcedure.class, SightberryVine2BlockValidPlacementConditionProcedure.class, TwistingGlobarBranchBlockValidPlacementConditionProcedure.class})
public abstract class AncientNutrientsMixin {
    @ModifyExpressionValue(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;", remap = true, ordinal = 0), remap = false)
    private static Block solidglobarbranches$otherAncientSoils(Block original) {
        if (original.builtInRegistryHolder().is(SGBTags.ANCIENT_NUTRIENT_SOIL)) {
            return SnifferentModBlocks.CLUB_MOSS.get();
        }
        return original;
    }
}