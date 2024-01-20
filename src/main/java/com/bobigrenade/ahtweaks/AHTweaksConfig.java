package com.bobigrenade.ahtweaks;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;


public class AHTweaksConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.ConfigValue<List<String>> whiteList;
    public static final ForgeConfigSpec.ConfigValue<List<String>> blackList;
    public static final ForgeConfigSpec.BooleanValue unbreakableBlocks;
    public static final ForgeConfigSpec.BooleanValue damagePlayer;
    public static final ForgeConfigSpec.ConfigValue<Integer> damageTick;

    static {

        builder.comment("AH Tweaks Configuration").push("common");
            builder.comment("Settings related to affected blocks").push("AffectedBlocks");
            whiteList = builder
                .comment("List of block tags that will always require the right tool to be used, even if they are harvestable without tools \nUse '#' before tags and '@' before mods like so [\"minecraft:oak_log\", \"#minecraft:logs\", \"@iceandfire\"]")
                .define("Whitelist", Arrays.asList("#minecraft:logs", "#minecraft:planks"));
            blackList = builder
                .comment("List of block tags that will never be affected by this mod \nUse '#' before tags and '@' before mods like so [\"minecraft:oak_log\", \"#minecraft:logs\", \"@iceandfire\"]")
                .define("Blacklist", Arrays.asList());
        builder.pop();

        builder.comment("Settings related to breaking blocks").push("BreakingBlocks");
            unbreakableBlocks = builder
                .comment("If true, affected blocks will be unbreakable without using the correct tool \nDefault: true")
                .define("Unbreakable Blocks", true);
        builder.pop();

        builder.comment("Settings related to player damage").push("PlayerDamage");
            damagePlayer = builder
                .comment("If true, affected blocks will damage the player when punched with bare hands \nDefault: false")
                .define("Damage Player", false);
            damageTick = builder
                .comment("The every of this number of ticks the player will take damage when breaking blocks (higher value less damage). Ignored if damagePlayer is false. \nRange: >1, default: 30")
                .define("Damage Tickrate", 30);

        builder.pop(2);
        spec = builder.build();
    }
}
