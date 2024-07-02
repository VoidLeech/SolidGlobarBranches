package com.github.voidleech.solidglobarbranches.mixin;

import net.mcreator.snifferent.item.GlobarSapBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlobarSapBottleItem.class)
public class GlobarSapBottleMixin extends Item {
    public GlobarSapBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"), remap = false)
    private void sgb$bottleRemainder(CallbackInfo ci){
        this.craftingRemainingItem = Items.GLASS_BOTTLE;
    }
}
