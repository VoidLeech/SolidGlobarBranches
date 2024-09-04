package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.registry.OblivionFurnaceFuel;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

public class SGBFuel {
    public static void register(){
        OblivionFurnaceFuel.addFurnaceFuel(SnifferentModItems.GLOBAR_BRANCH_MIDDLE, 100);
    }
}
