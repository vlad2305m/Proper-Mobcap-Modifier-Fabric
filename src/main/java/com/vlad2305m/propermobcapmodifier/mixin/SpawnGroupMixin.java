package com.vlad2305m.propermobcapmodifier.mixin;

import com.vlad2305m.propermobcapmodifier.config.ConfigManager;
import com.vlad2305m.propermobcapmodifier.config.SpawnGroupOptions;
import net.minecraft.entity.SpawnGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnGroup.class)
public class SpawnGroupMixin {
    @Shadow
    @Final
    private String name;

    @Inject(method = "getCapacity", at = @At("TAIL"), cancellable = true)
    private void getCapacityHook(CallbackInfoReturnable<Integer> cir) {
        SpawnGroupOptions options = getOptions();
        if (options == null) {
            return;
        }

        cir.setReturnValue(options.getCapacity());
    }

    @Inject(method = "isPeaceful", at = @At("TAIL"), cancellable = true)
    private void isPeacefulHook(CallbackInfoReturnable<Boolean> cir) {
        SpawnGroupOptions options = getOptions();
        if (options == null) {
            return;
        }

        cir.setReturnValue(options.isPeaceful());
    }

    @Inject(method = "isRare", at = @At("TAIL"), cancellable = true)
    private void isRareHook(CallbackInfoReturnable<Boolean> cir) {
        SpawnGroupOptions options = getOptions();
        if (options == null) {
            return;
        }

        cir.setReturnValue(options.isRare());
    }

    @Inject(method = "getDespawnStartRange", at = @At("TAIL"), cancellable = true)
    private void getDespawnStartRangeHook(CallbackInfoReturnable<Integer> cir) {
        SpawnGroupOptions options = getOptions();
        if (options == null) {
            return;
        }

        cir.setReturnValue(options.getDespawnStartRange());
    }

    @Inject(method = "getImmediateDespawnRange", at = @At("TAIL"), cancellable = true)
    private void getImmediateDespawnRangeHook(CallbackInfoReturnable<Integer> cir) {
        SpawnGroupOptions options = getOptions();
        if (options == null) {
            return;
        }

        cir.setReturnValue(options.getImmediateDespawnRange());
    }

    private SpawnGroupOptions getOptions() {
        if (!ConfigManager.isConfigUsable()) {
            return null;
        }

        return ConfigManager.getConfig().getSpawnGroups().get(name);
    }
}
