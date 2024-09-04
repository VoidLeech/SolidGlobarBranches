package com.github.voidleech.solidglobarbranches.mixin.farmland.spineflower;

import com.github.voidleech.solidglobarbranches.reimagined.ModdedFarmland;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.procedures.PlantSpineflowerSeedsProcedure;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlantSpineflowerSeedsProcedure.class)
public class SpineflowerPlacementMixin {
    @ModifyExpressionValue(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private static Block solidglobarbranches$moddedFarmlandIsAlsoFarmland(Block original){
        return ModdedFarmland.vanillafyFarmland(original);
    }
}
