package com.vlad2305m.propermobcapmodifier.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ConfigManager {
    private static ConfigHolder<MobcapModifierConfig> holder;

    public static void registerAutoConfig() {
        if (holder != null) {
            throw new IllegalStateException("Configuration already registered");
        }

        holder = AutoConfig.register(MobcapModifierConfig.class, JanksonConfigSerializer::new);
    }

    public static MobcapModifierConfig getConfig() {
        if (holder == null) {
            return MobcapModifierConfig.DEFAULT;
        }

        return holder.getConfig();
    }

    public static boolean isConfigUsable() {
        return holder != null && getConfig().isEnabled();
    }

    public static void reload() {
        if (holder == null) {
            return;
        }

        holder.load();
    }
}
