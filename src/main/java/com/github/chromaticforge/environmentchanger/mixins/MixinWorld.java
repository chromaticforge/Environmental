package com.github.chromaticforge.environmentchanger.mixins;

import com.github.chromaticforge.environmentchanger.config.EnvironmentChangerConfig;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class MixinWorld {
    @Shadow private long cloudColour;

    @Inject(method = "getCloudColour", at = @At("HEAD"))
    private void changeCloudColour(CallbackInfoReturnable<Integer> cir) {
        cloudColour = EnvironmentChangerConfig.INSTANCE.getCloudColor().getRGB();
    }
}
