package com.github.voidleech.solidglobarbranches.mixin.amber;

import net.mcreator.snifferent.block.AmberBlockBlock;
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
public class AmberBlockMixin extends Block {
    public AmberBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "onPlace", at = @At(value = "INVOKE",
            target = "Lnet/mcreator/snifferent/procedures/AmberGlowingUpdateTickProcedure;execute(Lnet/minecraft/world/level/LevelAccessor;DDD)V",
            shift = At.Shift.BEFORE), cancellable = true)
    private void sgb$cancelImmediateExecute(BlockState state, Level level, BlockPos pos, BlockState old, boolean b, CallbackInfo ci){
        ci.cancel();
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos){
        return 0;
    }
}
