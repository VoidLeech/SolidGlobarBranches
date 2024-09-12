package com.github.voidleech.solidglobarbranches.mixin.farmland.bloomplant;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.block.BloomPlant1Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(BloomPlant1Block.class)
public abstract class BloomPlant1Mixin extends FlowerBlock implements BonemealableBlock {

    public BloomPlant1Mixin(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos){
        return FlowerPlanting.isFarmland(state);
    }
}
