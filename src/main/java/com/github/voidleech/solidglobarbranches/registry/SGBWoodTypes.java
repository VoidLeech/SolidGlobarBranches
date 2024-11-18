package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.entities.OblivionBoatType;
import com.github.voidleech.oblivion.items.OblivionBoatItem;
import net.mcreator.snifferent.SnifferentMod;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public class SGBWoodTypes {
    // How to detect MCreator mod without decomp: no boats or signs
    public static final WoodType GLOBAR = WoodType.register(new WoodType(SnifferentMod.MODID + ":globar", BlockSetType.OAK));

    public enum SGBBoatType implements OblivionBoatType {

        GLOBAR(SnifferentModBlocks.GLOBAR_PLANKS.get(), "globar", SGBItems.GLOBAR_BOAT.get(), SGBItems.GLOBAR_CHEST_BOAT.get());
        private final String name;
        private final Supplier<? extends OblivionBoatItem> boat;
        private final Supplier<? extends OblivionBoatItem> chestBoat;
        private final Block planks;
        SGBBoatType(Block pPlanks, String pName, Supplier<? extends OblivionBoatItem> boat, Supplier<? extends OblivionBoatItem> chestBoat) {
            this.name = pName;
            this.boat = boat;
            this.chestBoat = chestBoat;
            this.planks = pPlanks;
            initOBT();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getNamespace() {
            return SnifferentMod.MODID;
        }

        @Override
        public Item getBoat() {
            return boat.get();
        }

        @Override
        public Item getChestBoat() {
            return chestBoat.get();
        }

        @Override
        public Block getPlanks() {
            return planks;
        }
    }
}
