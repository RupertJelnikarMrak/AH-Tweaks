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

        if (AHTweaksConfig.isBlacklist.get())
        {
            for (String entry : AHTweaksConfig.blockList.get())
            {
                if (entry.startsWith("%"))
                {
                    if (block.getTags().contains(new ResourceLocation(entry.replaceFirst("%", ""))))
                        return true;
                }
                else
                {
                    if (block.getRegistryName().toString().equals(entry))
                        return true;
                }
            }
            return canHarvestWithTool(state, player, held_item);
        }
        else
        {
            for (String entry : AHTweaksConfig.blockList.get())
            {
                if (entry.startsWith("%"))
                {
                    if (block.getTags().contains(new ResourceLocation(entry.replaceFirst("%", ""))))
                        return canHarvestWithTool(state, player, held_item);
                }
                else
                {
                    if (block.getRegistryName().toString().equals(entry))
                        return canHarvestWithTool(state, player, held_item);
                }
            }
            return true;
        }
    }

    private static boolean canHarvestWithTool(BlockState state, PlayerEntity player, ItemStack item_stack)
    {
        return item_stack.getToolTypes().contains(state.getHarvestTool());
       
        // *TODO: Add special checks for modded tools and levels
    }

}
