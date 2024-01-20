package com.bobigrenade.ahtweaks;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;


public class AHTweaksConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.ConfigValue<List<String>> blockList;
    public static final ForgeConfigSpec.BooleanValue isBlacklist;
    public static final ForgeConfigSpec.BooleanValue unbreakableBlocks;
    public static final ForgeConfigSpec.BooleanValue damagePlayer;
    public static final ForgeConfigSpec.ConfigValue<Integer> damageTick;

    static {

        builder.comment("AH Tweaks Configuration").push("common");
            builder.comment("Settings related to affected blocks").push("AffectedBlocks");
            blockList = builder
                .comment("List of block tags that will be affected by this mod \nUse '%' before tags like so [\"%minecraft:logs\", \"minecraft:oak_planks\"]")
                .define("Affected Blocks List", Arrays.asList());
            isBlacklist = builder
                .comment("If true, all blocks except the ones listed will be affected \nDefault: true")
                .define("Is Black List", true);
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
