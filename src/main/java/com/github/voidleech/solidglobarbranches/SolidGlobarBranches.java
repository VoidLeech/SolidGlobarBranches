package com.github.voidleech.solidglobarbranches;

import com.github.voidleech.solidglobarbranches.event.PackEvents;
import com.github.voidleech.solidglobarbranches.registry.SGBComposting;
import com.github.voidleech.solidglobarbranches.registry.SGBFuel;
import com.github.voidleech.solidglobarbranches.registry.SGBPacks;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
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

        }
    }
}
