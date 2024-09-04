package com.github.voidleech.solidglobarbranches.reimagined;

import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VineGrowing {

    public static void performBoneMeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState, Runnable popBerries) {
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_4.get()){
            if (serverLevel.isEmptyBlock(blockPos.above()) && randomSource.nextBoolean()){
                popBerries.run();
                return;
            }
        }
        growVine(serverLevel, randomSource, blockPos, blockState, true);
    }

    // 0 -> 1     always
    // 1 -> 2     always
    // 2 -> 3     always
    // if room above permits and random vine height permits
    // 3 -> 4     50%
    // 3 -> 3 + 2 50%
    // 4 -> 4 + 2 always
    public static void growVine(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState, boolean forcedGrowth) {
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_0.get()){
            serverLevel.setBlockAndUpdate(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_1.get().defaultBlockState());
            return;
        }
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_1.get()){
            serverLevel.setBlockAndUpdate(blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_2.get().defaultBlockState());
            BlockEntity newBE = serverLevel.getBlockEntity(blockPos);
            // Can only be grown on Club Moss, so height 1 is safe
            newBE.getPersistentData().putInt("height", 1);
            // Generate a random max height. Due to casting to int, will generally be between 4 and 9, rarely 3 or 10, 11 possible (depending on the implementation of random) as freak value.
            newBE.getPersistentData().putInt("maxHeight", (int)randomSource.triangle(7, 4));
            return;
        }
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_2.get()){
            advanceStageWithBE(serverLevel, blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_3.get().defaultBlockState());
            return;
        }
        if (serverLevel.isEmptyBlock(blockPos.above())){
            if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_3.get()){
                if (randomSource.nextBoolean()){
                    advanceStageWithBE(serverLevel, blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_4.get().defaultBlockState());
                    return;
                }
                growAboveWithBE(serverLevel, blockPos, forcedGrowth);
                return;
            }
            if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_4.get()){
                growAboveWithBE(serverLevel, blockPos, forcedGrowth);
                return;
            }
        }
        // no room, always grow berries
        if (blockState.getBlock() == SnifferentModBlocks.SNIFFBERRY_VINE_3.get()){
            advanceStageWithBE(serverLevel, blockPos, SnifferentModBlocks.SNIFFBERRY_VINE_4.get().defaultBlockState());
        }
    }

    // Hijack the BE system in snifferent to pass the height and a random max height, and whether the vine is trimmed, because adding additional blockstates via Mixins results in crashes during boot D:
    private static void advanceStageWithBE(ServerLevel serverLevel, BlockPos blockPos, BlockState newState) {
        BlockEntity initialBE = serverLevel.getBlockEntity(blockPos);
        CompoundTag tag = initialBE.getPersistentData();
        int height = tag.getInt("height");
        int maxHeight = tag.getInt("maxHeight");
        boolean trimmed = tag.getBoolean("trimmed");
        serverLevel.setBlockAndUpdate(blockPos, newState);
        BlockEntity newBE = serverLevel.getBlockEntity(blockPos);
        CompoundTag newTag = newBE.getPersistentData();
        newTag.putInt("height", height);
        newTag.putInt("maxHeight", maxHeight);
        newTag.putBoolean("trimmed", trimmed);
        newBE.setChanged();
    }

    private static void growAboveWithBE(ServerLevel serverLevel, BlockPos blockPos, boolean forcedGrowth) {
        if (blockPos.above().getY() >= serverLevel.getMaxBuildHeight()){
            return;
        }
        BlockEntity initialBE = serverLevel.getBlockEntity(blockPos);
        CompoundTag tag = initialBE.getPersistentData();
        int height = tag.getInt("height");
        int maxHeight = tag.getInt("maxHeight");
        boolean trimmed = tag.getBoolean("trimmed");
        if ((trimmed || height >= maxHeight) && !forcedGrowth) {
            return;
        }
        serverLevel.setBlockAndUpdate(blockPos.above(), SnifferentModBlocks.SNIFFBERRY_VINE_2.get().defaultBlockState());
        BlockEntity newBE = serverLevel.getBlockEntity(blockPos.above());
        CompoundTag newTag = newBE.getPersistentData();
        newTag.putInt("height", height + 1);
        newTag.putInt("maxHeight", maxHeight);
        newTag.putBoolean("trimmed", trimmed);
        newBE.setChanged();
    }
}
