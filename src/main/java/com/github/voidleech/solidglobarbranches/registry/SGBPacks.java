package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.registry.AbstractOblivionPacks;
import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Tuple;

import java.util.Map;

public class SGBPacks extends AbstractOblivionPacks {
    public SGBPacks() {
        super(Map.of(
                "just_bumpy_branches", new Tuple<>(Component.literal("Removes twigs from the sides of globar branches"), false),
                "straight_branches", new Tuple<>(Component.literal("Makes globar branches flat and straight"), false),
                "solid_globar_branches", new Tuple<>(Component.literal("snifferent model overrides"), true)),
                SolidGlobarBranches.MOD_ID, "SGB");
    }
}
