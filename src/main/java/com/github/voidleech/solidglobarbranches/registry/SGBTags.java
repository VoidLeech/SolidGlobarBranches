package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class SGBTags {
    public static final TagKey<EntityType<?>> DOESNT_BREAK_BRANCHES = ForgeRegistries.ENTITY_TYPES.tags()
            .createTagKey(new ResourceLocation(SolidGlobarBranches.MOD_ID, "doesnt_break_branches"));
}
