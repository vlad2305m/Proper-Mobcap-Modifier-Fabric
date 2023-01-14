package com.vlad2305m.propermobcapmodifier.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.entity.SpawnGroup;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Config(name = "mobcap_modifier")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
public class MobcapModifierConfig implements ConfigData {
    public static final MobcapModifierConfig DEFAULT = new MobcapModifierConfig();

    private boolean enabled = false;
    @Comment("""
            
            ^^^ Do not forget to enable the mod when you've changed something ^^^
            Below you will find a list of all the default values you are free to change:
            
            Before the '{', you can see the name of the group as Minecraft has set it. Do not change. More info at the bottom.
            capacity -- The cap. This is how much mobs per player to expect.
            peaceful -- Whether to spawn or despawn in peaceful difficulty.
            rare -- Spawns only every 20s (400 times more rare) (nice to have on monsters ;P)
            despawnStartRange -- Radial distance from which mobs, after being there for 30s, have ⅛% chance to despawn each 1/20 second averaging at 40s/mob.
            immediateDespawnRange -- Radial distance from which mobs are forced to despawn. If they can. (not riding a boat|named|generated with structure|...)
            """)
    private Map<String, SpawnGroupOptions> spawnGroups = Arrays.stream(SpawnGroup.values())
            .collect(Collectors.toMap(SpawnGroup::getName, SpawnGroupOptions::from));

    @SuppressWarnings({"TrailingWhitespaces", "unused"})
    @Comment("""
            
            
            Spawn groups as of 1.19.3:
            
            water_creature: dolphin, squid.
            
            underground_water_creature: glow_squid. yay! Minecraft ecosystem is so diverse...
            
            ambient: bat, just bat. Do you really need 15 bats?
            
            axolotls: axolotl. Elementary, my dear Watson.
            
            creature: allay, bee, cat, camel, chicken, cow, donkey, fox, frog, goat, horse, llama, mule, mooshroom, ocelot,\040
            panda, parrot, pig, polar_bear, rabbit, sheep, skeleton_horse, strider, tadpole, trader_llama (because it WILL despawn),\040
            turtle, wandering_trader (nowhere near villagers), wolf, zombie_horse.
            
            water_ambient: cod, pufferfish, salmon, tropical_fish.
            
            monster: blaze, cave_spider, creeper, drowned, elder_guardian, ender_dragon, enderman, endermite, evoker, ghast,\040
            giant, guardian, hoglin, husk, illusioner, magma_cube, phantom, piglin, piglin_brute, pillager, ravager, shulker,\040
            silverfish, skeleton, slime, spider, stray, vex, vindicator, warden, witch, wither, wither_skeleton, zoglin, zombie,\040
            zombie_villager, zombified_piglin.
            
            misc (could have been null, but misc. why?...): area_effect_cloud, armor_stand, arrow, boat, chest_boat, dragon_fireball,\040
            end_crystal, evoker_fangs, experience_orb, eye_of_ender, falling_block, firework_rocket, glow_item_frame, iron_golem,\040
            item, item_frame, fireball, leash_knot, lightning_bolt, llama_spit, marker (armor stand?), minecart, chest_minecart,\040
            command_block_minecart, furnace_minecart, hopper_minecart, spawner_minecart, tnt_minecart, painting, tnt, shulker_bullet,\040
            small_fireball, snow_golem, snowball, spectral_arrow, egg, ender_pearl, experience_bottle, potion, trident, villager,\040
            wither_skull, player, fishing_bobber.
            
            Thanks for reading!
            """)
    private final String authors = "vlad2305m, minecraft.fandom.com";

    public boolean isEnabled() {
        return enabled;
    }

    public Map<String, SpawnGroupOptions> getSpawnGroups() {
        return spawnGroups;
    }
}
