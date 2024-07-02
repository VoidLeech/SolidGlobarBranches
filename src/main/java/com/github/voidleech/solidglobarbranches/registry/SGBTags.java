package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class SGBTags {
    public static final TagKey<EntityType<?>> LIVING_DOESNT_BREAK_BRANCHES = ForgeRegistries.ENTITY_TYPES.tags()
            .createTagKey(new ResourceLocation(SolidGlobarBranches.MOD_ID, "living_doesnt_break_branches"));
    public static final TagKey<EntityType<?>> NONLIVING_DOES_BREAK_BRANCHES = ForgeRegistries.ENTITY_TYPES.tags()
            .createTagKey(new ResourceLocation(SolidGlobarBranches.MOD_ID, "nonliving_does_break_branches"));
}
