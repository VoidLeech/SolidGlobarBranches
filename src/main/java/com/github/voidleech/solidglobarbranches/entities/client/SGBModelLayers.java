package com.github.voidleech.solidglobarbranches.entities.client;

import net.mcreator.snifferent.SnifferentMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class SGBModelLayers {
    public static final ModelLayerLocation GLOBAR_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(SnifferentMod.MODID, "boat/globar"), "main");
    public static final ModelLayerLocation GLOBAR_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(SnifferentMod.MODID, "chest_boat/globar"), "main");
}
