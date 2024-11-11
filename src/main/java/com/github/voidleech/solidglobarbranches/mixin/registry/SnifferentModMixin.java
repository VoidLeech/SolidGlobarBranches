package com.github.voidleech.solidglobarbranches.mixin.registry;

import com.github.voidleech.solidglobarbranches.registry.SGBEntities;
import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.snifferent.SnifferentMod;
import net.minecraftforge.eventbus.api.IEventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnifferentMod.class)
public abstract class SnifferentModMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void solidglobarbranches$registerEntities(CallbackInfo ci, @Local IEventBus bus){
        SGBEntities.register(bus);
    }
}
