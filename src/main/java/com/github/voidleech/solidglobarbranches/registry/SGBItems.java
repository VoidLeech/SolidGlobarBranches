package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.items.OblivionBoatItem;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.mcreator.snifferent.init.SnifferentModTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SGBItems {
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SolidGlobarBranches.MOD_ID);
    // Actual Registry happens in mixins/registry/SnItemsMixin, this just serves as the api to access them since Mixin members cannot be public
    public static final AssignOnceSupplier<SignItem> GLOBAR_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<HangingSignItem> GLOBAR_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionBoatItem> GLOBAR_BOAT = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionBoatItem> GLOBAR_CHEST_BOAT = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(SGBItems::buildContents);
    }

    private static void buildContents(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == SnifferentModTabs.SNIFFIER_SNIFFERS.getKey()){
            event.accept(GLOBAR_SIGN.get());
            event.accept(GLOBAR_HANGING_SIGN.get());
            event.accept(GLOBAR_BOAT.get());
            event.accept(GLOBAR_CHEST_BOAT.get());
        }
    }
}
