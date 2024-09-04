package com.github.voidleech.solidglobarbranches.mixin.farmland.spindlefern;

import com.github.voidleech.solidglobarbranches.reimagined.ModdedFarmland;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.procedures.PlantSpindlefernSeedsProcedure;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlantSpindlefernSeedsProcedure.class)
public class SpindlefernPlacementMixin {
    @ModifyExpressionValue(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private static Block bgb$moddedFarmlandIsAlsoFarmland(Block original){
        return ModdedFarmland.vanillafyFarmland(original);
    }
}
