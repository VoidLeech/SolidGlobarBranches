package com.github.voidleech.solidglobarbranches.mixin.farmland.lumibulb;

import com.github.voidleech.solidglobarbranches.reimagined.ModdedFarmland;
import net.mcreator.snifferent.block.Lumibulb3Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(Lumibulb3Block.class)
public class Lumibulb3Mixin extends FlowerBlock {

    public Lumibulb3Mixin(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos){
        return ModdedFarmland.isFarmland(state);
    }
}
