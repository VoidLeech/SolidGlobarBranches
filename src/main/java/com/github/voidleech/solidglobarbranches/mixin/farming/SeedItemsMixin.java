package com.github.voidleech.solidglobarbranches.mixin.farming;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.item.BloomPlantNutItem;
import net.mcreator.snifferent.item.LumibulbSeedsItem;
import net.mcreator.snifferent.item.SightberrySeedlingItem;
import net.mcreator.snifferent.item.SpindlefernSeedsItem;
import net.mcreator.snifferent.item.SpineflowerSeedsItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {BloomPlantNutItem.class, LumibulbSeedsItem.class, SpindlefernSeedsItem.class, SpineflowerSeedsItem.class, SightberrySeedlingItem.class})
public abstract class SeedItemsMixin extends Item {
    public SeedItemsMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (FlowerPlanting.plantSeed(pContext, this)){
            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }
        return super.useOn(pContext);
    }
}
