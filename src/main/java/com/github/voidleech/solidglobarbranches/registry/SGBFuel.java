package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.util.RecipeLikeProperties;
import net.mcreator.snifferent.init.SnifferentModItems;

public class SGBFuel {
    public static void register(){
        RecipeLikeProperties.addFurnaceFuel(SnifferentModItems.GLOBAR_BRANCH_MIDDLE, 100);
    }
}
