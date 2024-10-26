package com.github.voidleech.solidglobarbranches.mixin.vines;

import com.github.voidleech.solidglobarbranches.registry.SGBTags;
import com.github.voidleech.solidglobarbranches.reimagined.VineGrowing;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.block.SightberryVine4Block;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SightberryVine4Block.class)
public abstract class SniffberryVine4Mixin extends Block implements BonemealableBlock {

    public SniffberryVine4Mixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static Properties solidglobarbranches$enableRandomTicks(Properties original){
        return original.randomTicks();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        VineGrowing.performBoneMeal(serverLevel, randomSource, blockPos, blockState,
                () -> popResource(serverLevel, blockPos, new ItemStack(SnifferentModItems.SNIFFBERRY.get())));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
        if (pRandom.nextDouble() > 0.067){
            VineGrowing.growVine(pLevel, pRandom, pPos, pState, false);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getItemInHand(pHand).getItem() == Items.BONE_MEAL){
            return InteractionResult.PASS;
        }
        if (SGBTags.isShears(pPlayer.getItemInHand(pHand).getItem())){
            BlockEntity be = pLevel.getBlockEntity(pPos);
            if (be.getPersistentData().getBoolean("trimmed")){
                return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
            }
            pPlayer.getItemInHand(pHand).hurtAndBreak(1, pPlayer, (p) -> p.broadcastBreakEvent(pHand));
            be.getPersistentData().putBoolean("trimmed", true);
            be.setChanged();
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        popResource(pLevel, pPos, new ItemStack(SnifferentModItems.SNIFFBERRY.get()));
        pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 0.8f + pLevel.getRandom().nextFloat() * 0.4f);
        pLevel.setBlockAndUpdate(pPos, SnifferentModBlocks.SNIFFBERRY_VINE_3.get().defaultBlockState());
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    @Inject(method = "neighborChanged",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;neighborChanged(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;Lnet/minecraft/core/BlockPos;Z)V", shift = At.Shift.AFTER),
            cancellable = true)
    private void solidglobarbranches$cancelWeirdUpdate(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving, CallbackInfo ci){
        ci.cancel();
    }
}
