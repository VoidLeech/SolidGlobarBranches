package com.github.voidleech.solidglobarbranches.reimagined;

import com.github.voidleech.oblivion.advancement.AdvancementHelper;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class FlowerPlanting {
    private static final ResourceLocation PLANT_SNIFFER_SEED = new ResourceLocation("minecraft:husbandry/plant_any_sniffer_seed");
    private static final Map<Item, BlockState> SEEDS_TO_PLANTS = Map.of(
            SnifferentModItems.BLOOM_PLANT_NUT.get(), SnifferentModBlocks.BLOOM_PLANT_0.get().defaultBlockState(),
            SnifferentModItems.LUMIBULB_SEEDS.get(), SnifferentModBlocks.LUMIBULB_0.get().defaultBlockState(),
            SnifferentModItems.SPINDLEFERN_SEEDS.get(), SnifferentModBlocks.SPINDLEFERN_0.get().defaultBlockState(),
            SnifferentModItems.SPINEFLOWER_SEEDS.get(), SnifferentModBlocks.SPINEFLOWER_0.get().defaultBlockState());
    public static boolean isFarmland(BlockState state) {
        return state.getBlock() instanceof FarmBlock;
    }

    public static boolean plantSeed(UseOnContext ctx, Item item) {
        BlockState blockState = SEEDS_TO_PLANTS.get(item);
        BlockPos pos = ctx.getClickedPos().relative(ctx.getClickedFace());
        Level level = ctx.getLevel();
        if (blockState != null && level.getBlockState(pos).canBeReplaced() && blockState.canSurvive(level, pos)){
            level.setBlockAndUpdate(pos, blockState);
            Player player = ctx.getPlayer();
            level.playSound(player, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
            AdvancementHelper.grantByName(PLANT_SNIFFER_SEED, player);
            if (!player.isCreative()){
                player.getItemInHand(ctx.getHand()).shrink(1);
            }
            return true;
        }
        return false;
    }
}
