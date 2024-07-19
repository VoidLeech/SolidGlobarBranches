package com.github.voidleech.solidglobarbranches.mixin.tree;

import net.mcreator.snifferent.procedures.TwistingGlobarBranchUpdateTickProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TwistingGlobarBranchUpdateTickProcedure.class)
public class RandomTickSaplingMixin {
    @ModifyArg(method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDD)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;setValue(Lnet/minecraft/world/level/block/state/properties/Property;Ljava/lang/Comparable;)Ljava/lang/Object;"),
            index = 1)
    private static Comparable sgb$swapNorthSouth(Property property, Comparable comparable){
        if (property instanceof DirectionProperty){
            if (comparable == Direction.NORTH || comparable == Direction.SOUTH){
                return ((Direction)comparable).getOpposite();
            }
        }
        return comparable;
    }
}
