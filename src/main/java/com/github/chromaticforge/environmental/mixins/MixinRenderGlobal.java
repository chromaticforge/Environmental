package com.github.chromaticforge.environmental.mixins;

import com.github.chromaticforge.environmental.config.EnvironmentalConfig;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderGlobal.class)
public class MixinRenderGlobal {
    @Shadow @Final private static ResourceLocation locationSunPng;
    @Shadow @Final private static ResourceLocation locationMoonPhasesPng;

    @Unique private final static ResourceLocation environmental$blankPng = new ResourceLocation("textures/environment/blank.png");

    @Redirect(
            method = "renderSky(FI)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V")
    )
    private void canSomeoneGiveMeAGuideOnNamingMixinsIDKWhatImDoing(TextureManager instance, ResourceLocation resource) {
        if (EnvironmentalConfig.INSTANCE.enabled) {
            if (resource == locationSunPng && EnvironmentalConfig.INSTANCE.getNoSun())
                resource = environmental$blankPng;
            if (resource == locationMoonPhasesPng && EnvironmentalConfig.INSTANCE.getNoMoon())
                resource = environmental$blankPng;
        }

        instance.bindTexture(resource);
    }
}
