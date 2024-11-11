package com.github.voidleech.solidglobarbranches.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class SGBWoodTypes {
    // How to detect MCreator mod without decomp: no boats or signs
    public static final WoodType GLOBAR = WoodType.register(new WoodType("snifferent:globar", BlockSetType.OAK));
}
