package com.github.voidleech.solidglobarbranches.mixin.farmland.lumibulb;

import com.github.voidleech.solidglobarbranches.util.ModdedFarmland;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.procedures.PlantLumibulbSeedsProcedure;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlantLumibulbSeedsProcedure.class)
public class LumibulbPlacementMixin {
    @ModifyExpressionValue(method="Lnet/mcreator/snifferent/procedures/PlantLumibulbSeedsProcedure;execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private static Block bgb$moddedFarmlandIsAlsoFarmland(Block original){
        return ModdedFarmland.vanillafyFarmland(original);
    }
}
