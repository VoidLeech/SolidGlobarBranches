package com.github.voidleech.solidglobarbranches.registry;

import com.github.voidleech.oblivion.blocks.OblivionHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionStandingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallSignBlock;
import com.github.voidleech.oblivion.registry.OblivionBlockEntities;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.solidglobarbranches.SolidGlobarBranches;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SGBBlocks {
    static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SolidGlobarBranches.MOD_ID);

    // Actual Registry happens in mixins/registry/SnBlocksMixin, this just serves as the api to access them since Mixin members cannot be public

    public static final AssignOnceSupplier<OblivionStandingSignBlock> GLOBAR_STANDING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallSignBlock> GLOBAR_WALL_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionHangingSignBlock> GLOBAR_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallHangingSignBlock> GLOBAR_WALL_HANGING_SIGN = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        OblivionBlockEntities.addSign(GLOBAR_STANDING_SIGN.get(), GLOBAR_WALL_SIGN.get(),
                GLOBAR_HANGING_SIGN.get(), GLOBAR_WALL_HANGING_SIGN.get());
    }
}
