package com.github.chromaticforge.environmental.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Checkbox
import cc.polyfrost.oneconfig.config.annotations.Color
import cc.polyfrost.oneconfig.config.annotations.KeyBind
import cc.polyfrost.oneconfig.config.annotations.Slider
import cc.polyfrost.oneconfig.config.annotations.Switch
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.config.core.OneKeyBind
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.libs.universal.UKeyboard
import com.github.chromaticforge.environmental.Environmental

object EnvironmentalConfig : Config(
    Mod(Environmental.NAME, ModType.UTIL_QOL, "/environmental_dark.svg"), "${Environmental.MODID}.json"
) {
    @Switch(name = "Time Changer", category = "Time")
    var timeChanger = false

    @Slider(name = "Time", description = "Sets the visual time.", min = 0f, max = 24f, category = "Time")
    var time = 12f

    @KeyBind(name = "Forward Key Bind", description = "Moves time forwards when pressed.", category = "Time")
    var forwardKey = OneKeyBind(UKeyboard.KEY_LBRACKET)

    @KeyBind(name = "Backward Key Bind", description = "Moves time backwards when pressed.", category = "Time")
    var backwardKey = OneKeyBind(UKeyboard.KEY_LBRACKET)

    @Switch(name = "Disable Sun", description = "Hides the sun from the sky", category = "Sky")
    var noSun = false

    @Switch(name = "Disable Moon", description = "Hides the moon from the sky", category = "Sky")
    var noMoon = false

    @Checkbox(name = "Custom Cloud Color", category = "Sky")
    var customCloud = false

    @Color(name = "Cloud Color", description = "Changes the color of the clouds", category = "Sky")
    var cloudColor = OneColor(255, 255, 255)

    init {
        initialize()

        addDependency("time", "timeChanger")
        addDependency("forwardKey", "timeChanger")
        addDependency("backwardKey", "timeChanger")
        addDependency("cloudColor", "customCloud")

        registerKeyBind(forwardKey) {
            time = ((time + 0.5f) % 24f + 24f) % 24f
        }

        registerKeyBind(backwardKey) {
            time -= ((time - 0.5f) % 24f + 24f) % 24f
        }
    }
}