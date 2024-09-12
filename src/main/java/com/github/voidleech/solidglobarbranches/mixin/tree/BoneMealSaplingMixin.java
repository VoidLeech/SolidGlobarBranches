package com.github.voidleech.solidglobarbranches.mixin.tree;

import net.mcreator.snifferent.procedures.BonemealGlobarProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BonemealGlobarProcedure.class)
public abstract class BoneMealSaplingMixin {
    @ModifyArg(method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDD)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;setValue(Lnet/minecraft/world/level/block/state/properties/Property;Ljava/lang/Comparable;)Ljava/lang/Object;", remap = true),
            index = 1, remap = false)
    private static Comparable solidglobarbranches$swapNorthSouth(Property property, Comparable comparable){
        if (property instanceof DirectionProperty){
            if (comparable == Direction.NORTH || comparable == Direction.SOUTH){
                return ((Direction)comparable).getOpposite();
            }
        }
        return comparable;
    }
}
