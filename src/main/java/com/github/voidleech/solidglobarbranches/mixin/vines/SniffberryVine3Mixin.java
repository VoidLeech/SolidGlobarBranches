package com.github.voidleech.solidglobarbranches.mixin.vines;

import com.github.voidleech.solidglobarbranches.util.VineGrowing;
import net.mcreator.snifferent.block.SightberryVine3Block;
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

@Mixin(SightberryVine3Block.class)
public class SniffberryVine3Mixin extends Block implements BonemealableBlock {
    public SniffberryVine3Mixin(Properties pProperties) {
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
            at = @At(value = "INVOKE", target = "Lnet/mcreator/snifferent/procedures/SightberryVine2NeighbourBlockChangesProcedure;execute(Lnet/minecraft/world/level/LevelAccessor;DDD)V", shift = At.Shift.BEFORE),
            cancellable = true)
    private void sgb$cancelWeirdUpdate(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving, CallbackInfo ci){
        ci.cancel();
    }
}
