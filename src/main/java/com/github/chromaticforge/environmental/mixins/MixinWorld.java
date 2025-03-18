package com.github.chromaticforge.environmental.mixins;

import com.github.chromaticforge.environmental.config.EnvironmentalConfig;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class MixinWorld {
    @Shadow private long cloudColour;

    @Inject(method = "getWorldTime", at = @At("HEAD"), cancellable = true)
    private void worldTime(CallbackInfoReturnable<Long> cir) {
        if (EnvironmentalConfig.INSTANCE.enabled && EnvironmentalConfig.INSTANCE.getTimeChanger()) {
            cir.setReturnValue((long)(EnvironmentalConfig.INSTANCE.getTime() * 1000f) + 18000L);
        }
    }

    @Inject(method = "getCloudColour", at = @At("HEAD"))
    private void changeCloudColour(CallbackInfoReturnable<Integer> cir) {
        if (EnvironmentalConfig.INSTANCE.enabled && EnvironmentalConfig.INSTANCE.getCustomCloud()) {
            cloudColour = EnvironmentalConfig.INSTANCE.getCloudColor().getRGB();
        } else {
            cloudColour = 0xffffff;
        }
    }
}
