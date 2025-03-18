package com.github.chromaticforge.environmental

import com.github.chromaticforge.environmental.config.EnvironmentalConfig
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = Environmental.MODID,
    name = Environmental.NAME,
    version = Environmental.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object Environmental {
    const val MODID: String = "@ID@"
    const val NAME: String = "@NAME@"
    const val VERSION: String = "@VER@"

    @Mod.EventHandler
    fun onFMLInitialization(event: FMLInitializationEvent) {
        EnvironmentalConfig
    }
}