package com.github.voidleech.solidglobarbranches.util;

import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class VineGrowing {

    public static void performBoneMeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState, Runnable popBerries) {
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_4.get()){
            if (serverLevel.getBlockState(blockPos.above()).getBlock() != Blocks.AIR || randomSource.nextBoolean()){
                popBerries.run();
                return;
            }
        }
        growVine(serverLevel, randomSource, blockPos, blockState);
    }

    // 0 -> 1     always
    // 1 -> 2     always
    // 2 -> 3     always
    // if room above permits
    // 3 -> 4     50%
    // 3 -> 3 + 2 50%
    // 4 -> 4 + 2 always
    public static void growVine(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_0.get()){
            serverLevel.setBlock(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_1.get().defaultBlockState(), 3);
            return;
        }
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_1.get()){
            serverLevel.setBlock(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_2.get().defaultBlockState(), 3);
            return;
        }
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_2.get()){
            serverLevel.setBlock(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_3.get().defaultBlockState(), 3);
            return;
        }
        if (serverLevel.getBlockState(blockPos.above()).getBlock() == Blocks.AIR){
            if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_3.get()){
                if (randomSource.nextBoolean()){
                    serverLevel.setBlock(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_4.get().defaultBlockState(), 3);
                    return;
                }
                serverLevel.setBlock(blockPos.above(), SnifferentModBlocks.SNIFFBERRY_VINE_2.get().defaultBlockState(), 3);
                return;
            }
            if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_4.get()){
                serverLevel.setBlock(blockPos.above(), SnifferentModBlocks.SNIFFBERRY_VINE_2.get().defaultBlockState(), 3);
                return;
            }
        }
        // no room, always grow berries
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_3.get()){
            serverLevel.setBlock(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_4.get().defaultBlockState(), 3);
        }
    }
}
