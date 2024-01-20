package com.bobigrenade.ahtweaks.util;

import com.bobigrenade.ahtweaks.AHTweaksConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public class HarvestBlockHandler {
    public static final ToolType SWORD = ToolType.get("sword");


    public static boolean canBreak(BlockState state, PlayerEntity player)
    {
        ItemStack held_item = player.getHeldItemMainhand();

        Block block = state.getBlock();

        // Check if the block is blacklisted
        for (String entry : AHTweaksConfig.blackList.get())
        {
            if (entry.startsWith("#"))
            {
                if (block.getTags().contains(new ResourceLocation(entry.replaceFirst("#", "")))){
                    return true;
                }
            }
            else if (entry.startsWith("@"))
            {
                if (block.getRegistryName().toString().equals(entry.replaceFirst("@", "").split(":")[0])){
                    return true;
                }
            }
            else
            {
                if (block.getRegistryName().toString().equals(entry)){
                    return true;
                }
            }
        }

        // Check if the block is whitelisted, if they are, do a different check whether the player is holding the right tool, not just if the block would drop
        for (String entry : AHTweaksConfig.whiteList.get())
        {
            if (entry.startsWith("#"))
            {
                if (block.getTags().contains(new ResourceLocation(entry.replaceFirst("#", "")))){
                    return held_item.getToolTypes().contains(state.getHarvestTool());
                }
            }
            else if (entry.startsWith("@"))
            {
                if (block.getRegistryName().toString().equals(entry.replaceFirst("@", "").split(":")[0])){
                    return held_item.getToolTypes().contains(state.getHarvestTool());
                }
            }
            else
            {
                if (block.getRegistryName().toString().equals(entry)){
                    return held_item.getToolTypes().contains(state.getHarvestTool());
                }
            }
        }

        // If no overrides are set, check if the block would drop when mined by player to decide wheter it is breakable or not
        return state.canHarvestBlock(null, null, player);
    }

    //private static boolean canHarvestWithTool(BlockState state, PlayerEntity player)
    //{
    //    return state.canHarvestBlock(null, null, player);
    //   
    //     *TODO: Add special checks for modded tools and levels
    //}

}
