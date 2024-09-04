package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.registry.OblivionFurnaceFuel;
import net.mcreator.snifferent.init.SnifferentModItems;

public class SGBFuel {
    public static void register(){
        OblivionFurnaceFuel.addFurnaceFuel(SnifferentModItems.GLOBAR_BRANCH_MIDDLE, 100);
    }
}
