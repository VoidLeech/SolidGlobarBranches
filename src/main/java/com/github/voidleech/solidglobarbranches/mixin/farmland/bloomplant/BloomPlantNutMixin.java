package com.github.voidleech.solidglobarbranches.mixin.farmland.bloomplant;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.item.BloomPlantNutItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BloomPlantNutItem.class)
public abstract class BloomPlantNutMixin extends Item {
    public BloomPlantNutMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (FlowerPlanting.plantSeed(pContext, SnifferentModBlocks.BLOOM_PLANT_0.get().defaultBlockState())){
            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }
        return super.useOn(pContext);
    }
}
