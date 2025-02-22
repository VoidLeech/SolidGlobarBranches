package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.util.RecipeLikeProperties;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.mcreator.snifferent.init.SnifferentModPotions;
import net.minecraft.world.item.alchemy.Potions;

public class SGBPotionRecipes {
    public static void register() {
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, SnifferentModItems.TUBER_FRUIT, SnifferentModPotions.RESISTANCE_POTION);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, SnifferentModItems.SNIFFBERRY, SnifferentModPotions.SNIFFING_POTION);
    }
}
