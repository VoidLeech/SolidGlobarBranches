package com.github.voidleech.solidglobarbranches.mixin.potion;

import net.mcreator.snifferent.init.SnifferentModItems;
import net.mcreator.snifferent.init.SnifferentModPotions;
import net.mcreator.snifferent.recipes.brewing.BrewResistancePotionBrewingRecipe;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewResistancePotionBrewingRecipe.class)
public abstract class ResistanceRecipeMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$recipeViewableResistanceRecipe(FMLCommonSetupEvent event, CallbackInfo ci){
        event.enqueueWork(() -> PotionBrewing.addMix(Potions.AWKWARD, SnifferentModItems.TUBER_FRUIT.get(), SnifferentModPotions.RESISTANCE_POTION.get()));
        ci.cancel();
    }
}
