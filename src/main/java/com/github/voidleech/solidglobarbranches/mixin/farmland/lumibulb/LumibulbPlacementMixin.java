package com.github.voidleech.solidglobarbranches.mixin.farmland.lumibulb;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.procedures.PlantLumibulbSeedsProcedure;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlantLumibulbSeedsProcedure.class)
public class LumibulbPlacementMixin {
    @ModifyExpressionValue(method="Lnet/mcreator/snifferent/procedures/PlantLumibulbSeedsProcedure;execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private static Block bgb$moddedFarmlandIsAlsoFarmland(Block original){
        if (original instanceof FarmBlock){
            return Blocks.FARMLAND;
        }
        return original;
    }
}
