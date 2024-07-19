package com.github.voidleech.solidglobarbranches.mixin.tree;

import net.mcreator.snifferent.block.PorusGlobarLog1Block;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PorusGlobarLog1Block.class)
public class PorusLog1Mixin extends Block {
    public PorusLog1Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(SnifferentModItems.PORUS_GLOBAR_LOG_0.get());
    }
}
