package com.github.voidleech.solidglobarbranches.mixin.farmland.spindlefern;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.mcreator.snifferent.item.SpindlefernSeedsItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpindlefernSeedsItem.class)
public abstract class SpindlefernSeedsMixin extends Item {
    public SpindlefernSeedsMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (FlowerPlanting.plantSeed(pContext, SnifferentModBlocks.SPINDLEFERN_0.get().defaultBlockState())){
            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }
        return super.useOn(pContext);
    }
}
