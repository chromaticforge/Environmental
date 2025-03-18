package com.github.chromaticforge.environmentchanger

import com.github.chromaticforge.environmentchanger.config.EnvironmentChangerConfig
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = EnvironmentChanger.MODID,
    name = EnvironmentChanger.NAME,
    version = EnvironmentChanger.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object EnvironmentChanger {
    const val MODID: String = "@ID@"
    const val NAME: String = "@NAME@"
    const val VERSION: String = "@VER@"

    @Mod.EventHandler
    fun onFMLInitialization(event: FMLInitializationEvent) {
        EnvironmentChangerConfig
    }
}