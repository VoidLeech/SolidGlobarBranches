package com.github.voidleech.solidglobarbranches.registry;

import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

public class SGBFuel {

    public static void addFuels(FurnaceFuelBurnTimeEvent event){
        if (event.getItemStack().getItem() == SnifferentModItems.GLOBAR_BRANCH_MIDDLE.get()){
            // Burns for half of an item
            event.setBurnTime(100);
        }
    }
}
