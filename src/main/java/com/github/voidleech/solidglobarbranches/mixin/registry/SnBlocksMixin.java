package com.github.voidleech.solidglobarbranches.mixin.registry;

import com.github.voidleech.oblivion.blocks.OblivionHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionStandingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallSignBlock;
import com.github.voidleech.solidglobarbranches.registry.SGBBlocks;
import com.github.voidleech.solidglobarbranches.registry.SGBWoodTypes;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SnifferentModBlocks.class)
public abstract class SnBlocksMixin {
    // This is one massive hack to get the signs registered under snifferent's mod id, s.t. mods like EveryCompat can detect them
    @Shadow
    @Final
    public static DeferredRegister<Block> REGISTRY;
    @Unique
    private static final RegistryObject<OblivionStandingSignBlock> SOLIDGLOBARBRANCHES$GLOBAR_STANDING_SIGN = REGISTRY.register("globar_sign", () ->
            new OblivionStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SGBWoodTypes.GLOBAR));

    @Unique
    private static final RegistryObject<OblivionWallSignBlock> SOLIDGLOBARBRANCHES$GLOBAR_WALL_SIGN = REGISTRY.register("globar_wall_sign", () ->
            new OblivionWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SGBWoodTypes.GLOBAR));

    @Unique
    private static final RegistryObject<OblivionHangingSignBlock> SOLIDGLOBARBRANCHES$GLOBAR_HANGING_SIGN = REGISTRY.register("globar_hanging_sign", () ->
            new OblivionHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SGBWoodTypes.GLOBAR));

    @Unique
    private static final RegistryObject<OblivionWallHangingSignBlock> SOLIDGLOBARBRANCHES$GLOBAR_HANGING_WALL_SIGN = REGISTRY.register("globar_hanging_wall_sign", () ->
            new OblivionWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SGBWoodTypes.GLOBAR));

    static {
        SGBBlocks.GLOBAR_STANDING_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_STANDING_SIGN);
        SGBBlocks.GLOBAR_WALL_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_WALL_SIGN);
        SGBBlocks.GLOBAR_HANGING_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_HANGING_SIGN);
        SGBBlocks.GLOBAR_HANGING_WALL_SIGN.assign(SOLIDGLOBARBRANCHES$GLOBAR_HANGING_WALL_SIGN);
    }
}
