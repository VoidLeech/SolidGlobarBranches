package com.github.voidleech.solidglobarbranches.mixin.amber;

import net.mcreator.snifferent.block.AmberGlowingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AmberGlowingBlock.class)
public class AmberBlockGlowingMixin extends Block {
    public AmberBlockGlowingMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos){
        return 0;
    }
}
