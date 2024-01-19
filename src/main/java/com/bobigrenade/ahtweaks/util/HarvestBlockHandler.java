package com.bobigrenade.ahtweaks.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;

public class HarvestBlockHandler {
    
    public static boolean canHarvest(BlockState state, PlayerEntity player)
    {
        Block block = state.getBlock();
        boolean is_wooden = block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.WOODEN_STAIRS) || block.isIn(BlockTags.WOODEN_SLABS) || block.isIn(BlockTags.WOODEN_FENCES) || block.isIn(BlockTags.PLANKS);

        return !is_wooden;
    }

}
