package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.solidglobarbranches.entities.SGBBoatEntity;
import com.github.voidleech.solidglobarbranches.entities.SGBChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SGBEntities {
    // Just get it under snifferent's id
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "snifferent");

    public static final RegistryObject<EntityType<SGBBoatEntity>> BOAT = ENTITIES.register("boat", () -> EntityType.Builder.<SGBBoatEntity>of(
            SGBBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("boat"));

    public static final RegistryObject<EntityType<SGBChestBoatEntity>> CHEST_BOAT = ENTITIES.register("chest_boat", () -> EntityType.Builder.<SGBChestBoatEntity>of(
            SGBChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("chest_boat"));

    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
    }
}
