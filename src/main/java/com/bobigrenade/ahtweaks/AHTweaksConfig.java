package com.bobigrenade.ahtweaks;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;


public class AHTweaksConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.ConfigValue<List<String>> blockTagWhitelist;

    static {

        builder.comment("AH Tweaks Configuration").push("common");

        blockTagWhitelist = builder
            .comment("List of block tags that will require an axe to be used")
            .define("blockTagWhitelist", Arrays.asList("minecraft:logs", "minecraft:planks", "minecraft:wooden_stairs", "minecraft:wooden_slabs", "minecraft:wooden_fences"));
            //.defineList("blockTagWhitelist", Arrays.asList("minecraft:sandstone", "minecraft:iron_trapdoor"), it -> it instanceof String);

        builder.pop();
        spec = builder.build();
    }
}
