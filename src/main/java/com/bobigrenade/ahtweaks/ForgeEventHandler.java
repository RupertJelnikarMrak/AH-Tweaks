package com.bobigrenade.ahtweaks;

import com.bobigrenade.ahtweaks.util.HarvestBlockHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
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
        PlayerEntity player = event.getPlayer();
        if (!HarvestBlockHandler.canBreak(event.getState(), player))
        {
            float newSpeed = 1e-10f;
            event.setNewSpeed(newSpeed);
            if (player.getHeldItemMainhand() == ItemStack.EMPTY)
            {
                player.attackEntityFrom(DamageSource.GENERIC, 1);
            }
        }
    }
    
}
