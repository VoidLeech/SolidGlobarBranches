package com.github.voidleech.solidglobarbranches.mixin.potion;

import net.mcreator.snifferent.recipes.brewing.BrewResistancePotionBrewingRecipe;
import net.mcreator.snifferent.recipes.brewing.BrewSniffingPotionBrewingRecipe;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {BrewResistancePotionBrewingRecipe.class, BrewSniffingPotionBrewingRecipe.class})
public abstract class PotionRecipesMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void solidglobarbranches$recipeViewablePotionRecipe(FMLCommonSetupEvent event, CallbackInfo ci){
        ci.cancel();
    }
}
