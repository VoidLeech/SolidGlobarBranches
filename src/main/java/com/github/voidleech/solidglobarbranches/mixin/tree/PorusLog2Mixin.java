package com.github.voidleech.solidglobarbranches.mixin.tree;

import net.mcreator.snifferent.block.PorusGlobarLog2Block;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PorusGlobarLog2Block.class)
public abstract class PorusLog2Mixin extends Block {
    public PorusLog2Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (stack.getItem() == Items.GLASS_BOTTLE){
            if (!pPlayer.isCreative()){
                stack.shrink(1);
            }
            pLevel.setBlockAndUpdate(pPos, SnifferentModBlocks.PORUS_GLOBAR_LOG_0.get().defaultBlockState());
            pPlayer.addItem(new ItemStack(SnifferentModItems.GLOBAR_SAP_BOTTLE.get()));
            pLevel.playSound(pPlayer, pPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(SnifferentModItems.PORUS_GLOBAR_LOG_0.get());
    }
}
