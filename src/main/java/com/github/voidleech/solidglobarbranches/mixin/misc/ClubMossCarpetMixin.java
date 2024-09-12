package com.github.voidleech.solidglobarbranches.mixin.misc;

import net.mcreator.snifferent.block.ClubMossCarpetBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClubMossCarpetBlock.class)
public abstract class ClubMossCarpetMixin extends Block {
    public ClubMossCarpetMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos){
        if (level instanceof LevelAccessor world){
            return !world.isEmptyBlock(pos.below());
        }
        return super.canSurvive(state, level, pos);
    }

    // Carpets cannot sustain plants. Why the tableflip is this Mixin Override needed
    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction dir, IPlantable plantable){
        return false;
    }
}
