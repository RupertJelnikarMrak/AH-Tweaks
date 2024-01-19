package com.bobigrenade.ahtweaks.util;

import com.bobigrenade.ahtweaks.AHTweaksConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class HarvestBlockHandler {
    public static final ToolType SWORD = ToolType.get("sword");


    public static boolean canBreak(BlockState state, PlayerEntity player)
    {
        boolean can_break = true;
        ItemStack held_item = player.getHeldItemMainhand();

        Block block = state.getBlock();
        List<String> tag_whitelist = AHTweaksConfig.blockTagWhitelist.get();

        for (String tag: tag_whitelist)
            if (block.getTags().contains(new ResourceLocation(tag))){
                can_break = canHarvestWithTool(state, player, held_item);
                break;
            }

        return can_break;
    }

    private static boolean canHarvestWithTool(BlockState state, PlayerEntity player, ItemStack item_stack)
    {
        return item_stack.getToolTypes().contains(state.getHarvestTool());
       
        // *TODO: Add special checks for modded tools and levels
    }

}
