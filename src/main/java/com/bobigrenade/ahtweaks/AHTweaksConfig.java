package com.bobigrenade.ahtweaks;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;


public class AHTweaksConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.ConfigValue<List<String>> blockTagWhitelist;
    public static final ForgeConfigSpec.BooleanValue unbreakableBlocks;
    public static final ForgeConfigSpec.BooleanValue damagePlayer;
    public static final ForgeConfigSpec.ConfigValue<Integer> damageTick;

    static {

        builder.comment("AH Tweaks Configuration").push("common");

        blockTagWhitelist = builder
            .comment("List of block tags that will be affected by this mod")
            .define("BlockTag Whitelist", Arrays.asList("minecraft:logs", "minecraft:planks", "minecraft:wooden_stairs", "minecraft:wooden_slabs", "minecraft:wooden_fences"));

        builder.comment("\n");

        unbreakableBlocks = builder
            .comment("If true, whitelisted blocks will be unbreakable without using the correct tool \nDefault: true")
            .define("Unbreakable Blocks", true);

        builder.comment("Settings related to player damage").push("PlayerDamage");

        damagePlayer = builder
            .comment("If true, whitelisted blocks will damage the player when punched with bare hands \nDefault: true")
            .define("Damage Player", true);

        damageTick = builder
            .comment("The every of this number of ticks the player will take damage when breaking blocks (higher value less damage). Ignored if damagePlayer is false. \nRange: >1, default: 30")
            .define("Damage Tickrate", 30);

        builder.pop();
        spec = builder.build();
    }
}
