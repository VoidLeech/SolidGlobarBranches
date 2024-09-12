package com.github.voidleech.solidglobarbranches.mixin.misc;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.ItemPropertiesRebuilder;
import net.mcreator.snifferent.item.GlobarSapBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlobarSapBottleItem.class)
public abstract class GlobarSapBottleMixin extends Item {
    public GlobarSapBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void solidglobarbranches$bottleRemainder(CallbackInfo ci){
        ItemPropertiesRebuilder.of(this)
                .craftingRemainder(Items.GLASS_BOTTLE)
                .finalizeRebuild();
    }
}
