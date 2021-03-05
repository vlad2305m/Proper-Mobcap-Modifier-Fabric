package com.vlad2305m.proper_mobcap_modifier;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Proper_mobcap_modifier implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(
                ModConfig.class,
                JanksonConfigSerializer::new
        );
    }
}
