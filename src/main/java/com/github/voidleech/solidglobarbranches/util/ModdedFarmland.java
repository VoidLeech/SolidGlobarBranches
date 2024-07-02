package com.github.voidleech.solidglobarbranches.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModdedFarmland {
    public static Block vanillafyFarmland(Block block){
        if (block instanceof FarmBlock){
            return Blocks.FARMLAND;
        }
        return block;
    }

    public static boolean isFarmland(BlockState state) {
        return state.getBlock() instanceof FarmBlock;
    }
}
