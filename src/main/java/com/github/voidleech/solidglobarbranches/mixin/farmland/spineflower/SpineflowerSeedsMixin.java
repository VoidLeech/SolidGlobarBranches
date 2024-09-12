package com.github.voidleech.solidglobarbranches.mixin.farmland.spineflower;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.item.SpineflowerSeedsItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpineflowerSeedsItem.class)
public abstract class SpineflowerSeedsMixin extends Item {
    public SpineflowerSeedsMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (FlowerPlanting.plantSeed(pContext, SnifferentModBlocks.SPINEFLOWER_0.get().defaultBlockState())){
            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }
        return super.useOn(pContext);
    }
}
