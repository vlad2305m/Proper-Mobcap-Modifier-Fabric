package com.vlad2305m.proper_mobcap_modifier;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.minecraft.entity.SpawnGroup;
import com.vlad2305m.proper_mobcap_modifier.util.SpawnGroupEasyRead;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@SuppressWarnings("unused")
@Config(name = "mobcaps_modifier")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class ModConfig implements ConfigData {

    @Comment("on/off switch")
    public boolean enabled = false;

    public Map<String, SpawnGroupEasyRead> GMO_spawngroups = Arrays.stream(SpawnGroup.values()).collect(Collectors
            .toMap(SpawnGroup::getName, SpawnGroupEasyRead::initWith));

}
