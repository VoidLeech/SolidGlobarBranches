package com.github.voidleech.solidglobarbranches.mixin.misc;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.item.GlobarSapBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GlobarSapBottleItem.class)
public abstract class GlobarSapBottleMixin extends Item {
    public GlobarSapBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;"))
    private static Properties solidglobarbranches$bottleRemainder(Properties original){
        return original.craftRemainder(Items.GLASS_BOTTLE);
    }
}
