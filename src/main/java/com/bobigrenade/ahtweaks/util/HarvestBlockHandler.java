package com.bobigrenade.ahtweaks.util;

import com.bobigrenade.ahtweaks.AHTweaksConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class HarvestBlockHandler {
    
    public static boolean canBreak(BlockState state, PlayerEntity player)
    {
        boolean can_break = true;

        Block block = state.getBlock();
        List<String> tag_whitelist = AHTweaksConfig.blockTagWhitelist.get();

        for (String tag: tag_whitelist)
            if (block.getTags().contains(new ResourceLocation(tag))){
                can_break = false;
                break;
            }

        return can_break;
    }

}
