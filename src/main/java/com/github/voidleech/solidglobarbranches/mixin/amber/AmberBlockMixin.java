package com.github.voidleech.solidglobarbranches.mixin.amber;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.block.AmberBlockBlock;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AmberBlockBlock.class)
public abstract class AmberBlockMixin extends Block {
    public AmberBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "onPlace", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;scheduleTick(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;I)V",
            shift = At.Shift.AFTER), cancellable = true)
    private void solidglobarbranches$cancelImmediateExecute(BlockState state, Level level, BlockPos pos, BlockState old, boolean b, CallbackInfo ci){
        ci.cancel();
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos){
        return 0;
    }

    @ModifyExpressionValue(method = "skipRendering(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private Block solidglobarbranches$allAmberEqual(Block original){
        if (original == SnifferentModBlocks.AMBER_GLOWING.get()){
            return SnifferentModBlocks.AMBER_BLOCK.get();
        }
        return original;
    }
}
