package com.bobigrenade.ahtweaks;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;


public class AHTweaksConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.ConfigValue<List<String>> blockTagWhitelist;
    public static final ForgeConfigSpec.BooleanValue damagePlayer;

    static {

        builder.comment("AH Tweaks Configuration").push("common");

        blockTagWhitelist = builder
            .comment("List of block tags that will require their respected tool to be used")
            .define("BlockTag Whitelist", Arrays.asList("minecraft:logs", "minecraft:planks", "minecraft:wooden_stairs", "minecraft:wooden_slabs", "minecraft:wooden_fences"));

        damagePlayer = builder
            .comment("If true, the player will take damage when they try to break a whitelisted block without a tool")
            .define("Damage Player", true);

        builder.pop();
        spec = builder.build();
    }
}
