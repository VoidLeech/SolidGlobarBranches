package com.github.voidleech.solidglobarbranches.mixin.vines;

import com.github.voidleech.solidglobarbranches.reimagined.VineGrowing;
import net.mcreator.snifferent.block.SightberryVine2Block;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SightberryVine2Block.class)
public class SniffberryVine2Mixin extends Block implements BonemealableBlock {
    public SniffberryVine2Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        VineGrowing.performBoneMeal(serverLevel, randomSource, blockPos, blockState, () -> {});
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
        if (pRandom.nextDouble() > 0.067){
            VineGrowing.growVine(pLevel, pRandom, pPos, pState, false);
        }
    }

    @Inject(method = "neighborChanged",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;neighborChanged(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;Lnet/minecraft/core/BlockPos;Z)V", shift = At.Shift.AFTER),
            cancellable = true)
    private void solidglobarbranches$cancelWeirdUpdate(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving, CallbackInfo ci){
        ci.cancel();
    }
}
