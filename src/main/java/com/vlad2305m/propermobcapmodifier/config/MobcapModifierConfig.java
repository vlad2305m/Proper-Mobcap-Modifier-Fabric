package com.vlad2305m.propermobcapmodifier.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import net.minecraft.entity.SpawnGroup;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Config(name = "mobcap_modifier")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class MobcapModifierConfig implements ConfigData {
    public static final MobcapModifierConfig DEFAULT = new MobcapModifierConfig();

    private boolean enabled = false;
    private Map<String, SpawnGroupOptions> spawnGroups = Arrays.stream(SpawnGroup.values())
            .collect(Collectors.toMap(SpawnGroup::getName, SpawnGroupOptions::from));

    public boolean isEnabled() {
        return enabled;
    }

    public Map<String, SpawnGroupOptions> getSpawnGroups() {
        return spawnGroups;
    }
}
