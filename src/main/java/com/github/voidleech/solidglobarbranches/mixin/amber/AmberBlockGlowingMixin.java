package com.github.voidleech.solidglobarbranches.mixin.amber;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.block.AmberGlowingBlock;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AmberGlowingBlock.class)
public class AmberBlockGlowingMixin extends Block {
    public AmberBlockGlowingMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos){
        return 0;
    }

    @ModifyExpressionValue(method = "skipRendering(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private Block solidglobarbranches$allAmberEqual(Block original){
        if (original == SnifferentModBlocks.AMBER_BLOCK.get()){
            return SnifferentModBlocks.AMBER_GLOWING.get();
        }
        return original;
    }
}
