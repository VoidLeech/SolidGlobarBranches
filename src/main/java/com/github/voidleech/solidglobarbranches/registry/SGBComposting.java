package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.registry.OblivionComposting;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class SGBComposting {
    public static void register() {
        add(SnifferentModItems.BLOOM_PLANT, 0.85f);
        add(SnifferentModItems.SPINEFLOWER, 0.85f);
        add(SnifferentModItems.SPINDLEFERN, 0.85f);
        add(SnifferentModItems.TALL_SPINDLEFERN, 0.85f);
        add(SnifferentModItems.LUMIBULB, 0.85f);
        add(SnifferentModItems.CLUB_MOSS, 0.85f);
        add(SnifferentModItems.CLUB_MOSS_CARPET, 0.5f);
        add(SnifferentModItems.SNIFFBERRY, 0.5f);
        add(SnifferentModItems.TUBER_FRUIT, 0.5f);
        add(SnifferentModItems.BLOOM_PLANT_NUT, 0.3f);
        add(SnifferentModItems.LUMIBULB_SEEDS, 0.3f);
        add(SnifferentModItems.SPINEFLOWER_SEEDS, 0.3f);
        add(SnifferentModItems.SPINDLEFERN_SEEDS, 0.3f);
        add(SnifferentModItems.SNIFFBERRY_SEEDLING, 0.3f);
        add(SnifferentModItems.BLOOM_PLANT_NUT, 0.3f);
        add(SnifferentModItems.CLUB_MOSS_PATCH, 0.3f);
        add(SnifferentModItems.GLOBAR_SAPLING, 0.3f);
        add(SnifferentModItems.GLOBAR_BRANCH_MIDDLE, 0.1f);
    }
    
    private static void add(RegistryObject<Item> item, float chance){
        OblivionComposting.addCompostable(item::get, chance);
    }
}
