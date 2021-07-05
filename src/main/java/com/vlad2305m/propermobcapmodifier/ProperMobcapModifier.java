package com.vlad2305m.propermobcapmodifier;

import com.vlad2305m.propermobcapmodifier.config.ConfigManager;
import net.fabricmc.api.ModInitializer;

public class ProperMobcapModifier implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigManager.registerAutoConfig();
    }
}
