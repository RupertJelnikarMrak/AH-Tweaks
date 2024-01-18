package com.bobigrenade.ahtweaks.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup AHTWEAKS_GROUP = new ItemGroup("AHTweaksTab") 
    {
        @Override
        public ItemStack createIcon() 
        {
            return new ItemStack(ModItems.AMETHYST.get());
        }
    };
    
}
