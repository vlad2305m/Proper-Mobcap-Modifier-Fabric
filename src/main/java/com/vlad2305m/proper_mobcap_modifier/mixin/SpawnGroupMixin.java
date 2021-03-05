package com.vlad2305m.proper_mobcap_modifier.mixin;

import com.vlad2305m.proper_mobcap_modifier.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.SpawnGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnGroup.class)
public class SpawnGroupMixin {

    @Shadow @Final private String name;

    private boolean unlocked = false;
    private int unlock_count = 0;

    @Inject(method = "getCapacity", at = @At("TAIL"), cancellable = true)
    private void capacityImpersonator(CallbackInfoReturnable<Integer> cir) {
        if(unlocked) {
            if (AutoConfig.getConfigHolder(ModConfig.class).getConfig().enabled) {
                cir.setReturnValue(AutoConfig.getConfigHolder(ModConfig.class).getConfig().GMO_spawngroups.get(name).spawn_cap);
            }
        }
        else {
            unlock_count++;
            if (unlock_count > 100) unlocked = true;
        }
    }

    @Inject(method = "isPeaceful", at = @At("TAIL"), cancellable = true)
    private void peacefulImpersonator(CallbackInfoReturnable<Boolean> cir) {
        if(unlocked) {
            if (AutoConfig.getConfigHolder(ModConfig.class).getConfig().enabled) {
                cir.setReturnValue(AutoConfig.getConfigHolder(ModConfig.class).getConfig().GMO_spawngroups.get(name).is_peaceful);
            }
        }
    }

    @Inject(method = "isAnimal", at = @At("TAIL"), cancellable = true)
    private void animalImpersonator(CallbackInfoReturnable<Boolean> cir) {
        if(unlocked) {
            if (AutoConfig.getConfigHolder(ModConfig.class).getConfig().enabled) {
                cir.setReturnValue(AutoConfig.getConfigHolder(ModConfig.class).getConfig().GMO_spawngroups.get(name).is_an_animal);
            }
        }
    }

    @Inject(method = "getDespawnStartRange", at = @At("TAIL"), cancellable = true)
    private void despawnStartImpersonator(CallbackInfoReturnable<Integer> cir) {
        if(unlocked) {
            if (AutoConfig.getConfigHolder(ModConfig.class).getConfig().enabled) {
                cir.setReturnValue(AutoConfig.getConfigHolder(ModConfig.class).getConfig().GMO_spawngroups.get(name).can_despawn_range);
            }
        }
    }

    @Inject(method = "getImmediateDespawnRange", at = @At("TAIL"), cancellable = true)
    private void despawnImmediateImpersonator(CallbackInfoReturnable<Integer> cir) {
        if(unlocked) {
            if (AutoConfig.getConfigHolder(ModConfig.class).getConfig().enabled) {
                cir.setReturnValue(AutoConfig.getConfigHolder(ModConfig.class).getConfig().GMO_spawngroups.get(name).should_despawn_range);
            }
        }
    }

}
