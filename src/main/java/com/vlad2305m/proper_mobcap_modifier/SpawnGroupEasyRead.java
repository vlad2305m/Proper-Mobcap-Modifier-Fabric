package com.vlad2305m.proper_mobcap_modifier;

import net.minecraft.entity.SpawnGroup;

public class SpawnGroupEasyRead { ;
    public int spawn_cap = 0;
    public boolean is_peaceful = false;
    public boolean is_an_animal = false;
    public int can_despawn_range = 32;
    public int should_despawn_range = 128;

    public SpawnGroupEasyRead() {
    }

    public SpawnGroupEasyRead Setup(SpawnGroup spawnGroup) {
        spawn_cap = spawnGroup.getCapacity();
        is_peaceful = spawnGroup.isPeaceful();
        is_an_animal = spawnGroup.isAnimal();
        can_despawn_range = spawnGroup.getDespawnStartRange();
        should_despawn_range = spawnGroup.getImmediateDespawnRange();
        return this;
    }

}
