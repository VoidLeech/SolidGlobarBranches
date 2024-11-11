package com.github.voidleech.solidglobarbranches;

import com.github.voidleech.solidglobarbranches.entities.client.SGBBoatRenderer;
import com.github.voidleech.solidglobarbranches.entities.client.SGBModelLayers;
import com.github.voidleech.solidglobarbranches.registry.SGBBlocks;
import com.github.voidleech.solidglobarbranches.registry.SGBComposting;
import com.github.voidleech.solidglobarbranches.registry.SGBEntities;
import com.github.voidleech.solidglobarbranches.registry.SGBFuel;
import com.github.voidleech.solidglobarbranches.registry.SGBItems;
import com.github.voidleech.solidglobarbranches.registry.SGBPacks;
import com.github.voidleech.solidglobarbranches.registry.SGBWoodTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SolidGlobarBranches.MOD_ID)
public class SolidGlobarBranches
{
    public static final String MOD_ID = "solidglobarbranches";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SolidGlobarBranches()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        new SGBPacks().register(modEventBus);
        SGBBlocks.register(modEventBus);
        SGBItems.register(modEventBus);
        // SGBEntities.register(modEventBus); NOPE (We inject into snifferent's constructor instead)

        SGBComposting.register();
        SGBFuel.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                Sheets.addWoodType(SGBWoodTypes.GLOBAR);

                EntityRenderers.register(SGBEntities.BOAT.get(), context -> new SGBBoatRenderer(context, false));
                EntityRenderers.register(SGBEntities.CHEST_BOAT.get(), context -> new SGBBoatRenderer(context, true));
            });
        }

        @SubscribeEvent
        public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(SGBModelLayers.GLOBAR_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(SGBModelLayers.GLOBAR_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }
    }
}
