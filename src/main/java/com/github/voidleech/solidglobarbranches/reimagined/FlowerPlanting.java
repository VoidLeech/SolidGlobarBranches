package com.github.voidleech.solidglobarbranches.reimagined;

import com.github.voidleech.oblivion.advancement.AdvancementHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlowerPlanting {
    public static boolean isFarmland(BlockState state) {
        return state.getBlock() instanceof FarmBlock;
    }

    public static boolean plantSeed(UseOnContext ctx, BlockState blockState) {
        BlockPos pos = ctx.getClickedPos().relative(ctx.getClickedFace());
        Level level = ctx.getLevel();
        if (level.getBlockState(pos).canBeReplaced() && blockState.canSurvive(level, pos)){
            level.setBlockAndUpdate(pos, blockState);
            Player player = ctx.getPlayer();
            level.playSound(player, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
            AdvancementHelper.grantByName("minecraft:husbandry/plant_any_sniffer_seed", player);
            if (!player.isCreative()){
                player.getItemInHand(ctx.getHand()).shrink(1);
            }
            return true;
        }
        return false;
    }
}
