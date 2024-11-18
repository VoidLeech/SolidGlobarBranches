package com.github.voidleech.solidglobarbranches.mixin.registry;

import com.github.voidleech.oblivion.items.OblivionBoatItem;
import com.github.voidleech.solidglobarbranches.registry.SGBBlocks;
import com.github.voidleech.solidglobarbranches.registry.SGBItems;
import com.github.voidleech.solidglobarbranches.registry.SGBWoodTypes;
import net.mcreator.snifferent.init.SnifferentModItems;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SnifferentModItems.class)
public abstract class SnItemsMixin {
    // This is one massive hack to get the signs & boats registered under snifferent's mod id, s.t. mods like EveryCompat can detect them
    @Shadow
    @Final
    public static DeferredRegister<Item> REGISTRY;
    @Unique
    private static final RegistryObject<SignItem> SOLIDGLOBARBRANCHES$GLOBAR_SIGN = REGISTRY.register("globar_sign", () ->
            new SignItem(new Item.Properties().stacksTo(16), SGBBlocks.GLOBAR_STANDING_SIGN.get().get(), SGBBlocks.GLOBAR_WALL_SIGN.get().get()));

    @Unique
    private static final RegistryObject<HangingSignItem> SOLIDGLOBARBRANCHES$GLOBAR_HANGING_SIGN = REGISTRY.register("globar_hanging_sign", () ->
            new HangingSignItem(SGBBlocks.GLOBAR_HANGING_SIGN.get().get(), SGBBlocks.GLOBAR_WALL_HANGING_SIGN.get().get(), new Item.Properties().stacksTo(16)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> SOLIDGLOBARBRANCHE$GLOBAR_BOAT = REGISTRY.register("globar_boat",
            () -> new OblivionBoatItem(false, SGBWoodTypes.SGBBoatType.GLOBAR, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> SOLIDGLOBARBRANCHE$GLOBAR_CHEST_BOAT = REGISTRY.register("globar_chest_boat",
            () -> new OblivionBoatItem(true, SGBWoodTypes.SGBBoatType.GLOBAR, new Item.Properties().stacksTo(1)));

    static {
        SGBItems.GLOBAR_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_SIGN);
        SGBItems.GLOBAR_HANGING_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_HANGING_SIGN);
        SGBItems.GLOBAR_BOAT.assign(SOLIDGLOBARBRANCHE$GLOBAR_BOAT);
        SGBItems.GLOBAR_CHEST_BOAT.assign(SOLIDGLOBARBRANCHE$GLOBAR_CHEST_BOAT);
    }
}
