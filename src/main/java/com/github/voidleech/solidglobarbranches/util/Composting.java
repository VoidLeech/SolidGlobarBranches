package com.github.voidleech.solidglobarbranches.util;

import net.mcreator.snifferent.block.AmberBlockBlock;
import net.mcreator.snifferent.block.AmberGlassBlock;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class Composting {
    public static void addCompostables() {
        add(0.85f, SnifferentModItems.BLOOM_PLANT.get());
        add(0.85f, SnifferentModItems.SPINEFLOWER.get());
        add(0.85f, SnifferentModItems.SPINDLEFERN.get());
        add(0.85f, SnifferentModItems.TALL_SPINDLEFERN.get());
        add(0.85f, SnifferentModItems.LUMIBULB.get());
        add(0.85f, SnifferentModItems.CLUB_MOSS.get());
        add(0.5f, SnifferentModItems.CLUB_MOSS_CARPET.get());
        add(0.5f, SnifferentModItems.SNIFFBERRY.get());
        add(0.5f, SnifferentModItems.TUBER_FRUIT.get());
        add(0.3f, SnifferentModItems.BLOOM_PLANT_NUT.get());
        add(0.3f, SnifferentModItems.LUMIBULB_SEEDS.get());
        add(0.3f, SnifferentModItems.SPINEFLOWER_SEEDS.get());
        add(0.3f, SnifferentModItems.SPINDLEFERN_SEEDS.get());
        add(0.3f, SnifferentModItems.SNIFFBERRY_SEEDLING.get());
        add(0.3f, SnifferentModItems.BLOOM_PLANT_NUT.get());
        add(0.3f, SnifferentModItems.CLUB_MOSS_PATCH.get());
    }

    private static void add(float chance, ItemLike item){
        ComposterBlock.add(chance, item);
    }
}
