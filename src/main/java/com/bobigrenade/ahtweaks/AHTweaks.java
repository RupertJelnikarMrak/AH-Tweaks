package com.bobigrenade.ahtweaks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AHTweaks.MOD_ID)
public class AHTweaks
{
    public static final String MOD_ID = "ahtweaks";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public AHTweaks() {
        LOGGER.info("Constructing AHTweaks");

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        LOGGER.info("Setup");
        ForgeEventHandler.init();
    }
}
