package com.github.voidleech.solidglobarbranches.mixin.farmland.lumibulb;

import com.github.voidleech.solidglobarbranches.util.ModdedFarmlandUtil;
import net.mcreator.snifferent.block.Lumibulb1Block;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Supplier;

@Mixin(Lumibulb1Block.class)
public class Lumibulb1Mixin extends FlowerBlock implements BonemealableBlock {

    public Lumibulb1Mixin(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }

    @Shadow
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b){
        throw new AbstractMethodError("Shadow");
    }

    @Shadow
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        throw new AbstractMethodError("Shadow");
    }

    @Shadow
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        throw new AbstractMethodError("Shadow");
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos){
        return ModdedFarmlandUtil.isFarmland(state);
    }
}
