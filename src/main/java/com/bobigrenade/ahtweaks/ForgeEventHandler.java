package com.bobigrenade.ahtweaks;

import com.bobigrenade.ahtweaks.util.HarvestBlockHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;

public class ForgeEventHandler {

    public static void init()
    {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, ForgeEventHandler::onBreakSpeed);
    }

    public static void onBreakSpeed(PlayerEvent.BreakSpeed event)
    {


        if (!HarvestBlockHandler.canBreak(event.getState(), event.getPlayer()))
        {
            float newSpeed = 1e-10f;
            event.setNewSpeed(newSpeed);
        }
    }
    
}
