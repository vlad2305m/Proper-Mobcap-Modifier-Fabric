package com.vlad2305m.proper_mobcap_modifier;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.minecraft.entity.SpawnGroup;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Config(name = "mobcaps_modifier")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class ModConfig implements ConfigData {

    @Comment("on/off switch")
    public boolean enabled = false;

    public Map<String, SpawnGroupEasyRead> GMO_spawngroups = new HashMap<String, SpawnGroupEasyRead>() {{
        put(SpawnGroup.MONSTER.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.MONSTER));
        put(SpawnGroup.CREATURE.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.CREATURE));
        put(SpawnGroup.AMBIENT.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.AMBIENT));
        put(SpawnGroup.WATER_CREATURE.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.WATER_CREATURE));
        put(SpawnGroup.WATER_AMBIENT.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.WATER_AMBIENT));
        put(SpawnGroup.MISC.getName(), new SpawnGroupEasyRead().Setup(SpawnGroup.MISC));
    }};

}
