package com.vlad2305m.proper_mobcap_modifier.mixin;

import com.vlad2305m.proper_mobcap_modifier.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.server.command.ReloadCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ReloadCommand.class)
public class ReloadMixin {

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_13530(Lcom/mojang/brigadier/context/CommandContext;)I", at = @At("HEAD"))
    private static void reloadConfig(CallbackInfoReturnable<Integer> info) {
        AutoConfig.getConfigHolder(ModConfig.class).load();
    }
}
