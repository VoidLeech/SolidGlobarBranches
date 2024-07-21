package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.tags.ITagManager;

public class SGBTags {
    public static final TagKey<EntityType<?>> LIVING_DOESNT_BREAK_BRANCHES = self(ForgeRegistries.ENTITY_TYPES, "living_doesnt_break_branches");
    public static final TagKey<EntityType<?>> NONLIVING_DOES_BREAK_BRANCHES = self(ForgeRegistries.ENTITY_TYPES, "nonliving_does_break_branches");

    public static boolean isShears(Item item){
        return item.builtInRegistryHolder().is(SHEARS) || item.builtInRegistryHolder().is(TOOLS_SHEARS);
    }

    private static final TagKey<Item> SHEARS = forge(ForgeRegistries.ITEMS, "shears");
    // The above is the normal tag, but you might have mods (somewhat logically) assume their shears should be in the below tag
    private static final TagKey<Item> TOOLS_SHEARS = forge(ForgeRegistries.ITEMS, "tools/shears");



    private static <T> TagKey<T> self(IForgeRegistry<T> registry, String name){
        return registry.tags().createTagKey(new ResourceLocation(SolidGlobarBranches.MOD_ID, name));
    }

    private static <T> TagKey<T> forge(IForgeRegistry<T> registry, String name){
        return registry.tags().createTagKey(new ResourceLocation("forge", name));
    }
}
