package com.github.voidleech.solidglobarbranches.mixin.farmland.bloomplant;

import com.github.voidleech.solidglobarbranches.util.ModdedFarmlandUtil;
import net.mcreator.snifferent.block.BloomPlant4Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BloomPlant4Block.class)
public class BloomPlant4Mixin extends DoublePlantBlock {

    public BloomPlant4Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos){
        return ModdedFarmlandUtil.isFarmland(state);
    }
}
