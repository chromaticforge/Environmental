package com.github.chromaticforge.environmentchanger.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Color
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import com.github.chromaticforge.environmentchanger.EnvironmentChanger

object EnvironmentChangerConfig : Config(
    Mod(EnvironmentChanger.NAME, ModType.UTIL_QOL, "/environmentchanger_dark.svg"), "${EnvironmentChanger.MODID}.json"
) {
    init {
        initialize()
    }

    @Color(name = "Cloud Color")
    var cloudColor = OneColor(255, 255, 255)
}