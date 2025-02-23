package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.util.Registration;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;

public class SGBPacks {
    public static final Registration.PackData SGB = new Registration.PackData("solid_globar_branches", Component.literal("SGB: snifferent Asset Overrides"), true, true, PackType.CLIENT_RESOURCES);
    public static final Registration.PackData STRAIGHT = new Registration.PackData("straight_branches", Component.literal("SGB: Straight Branches"), false, false, PackType.CLIENT_RESOURCES);
    public static final Registration.PackData NO_TWIGS = new Registration.PackData("just_bumpy_branches", Component.literal("SGB: Just Bumpy Branches"), false, false, PackType.CLIENT_RESOURCES);
    public static final Registration.PackData NO_EGGS = new Registration.PackData("no_spawn_egg_crafting", Component.literal("SGB: Disable Spawn Egg Crafting"), false, true, PackType.SERVER_DATA);
}
