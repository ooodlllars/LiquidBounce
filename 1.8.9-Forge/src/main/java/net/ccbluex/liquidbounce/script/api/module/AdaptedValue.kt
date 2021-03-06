/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.script.api.module

import net.ccbluex.liquidbounce.value.FloatValue
import net.ccbluex.liquidbounce.value.IntegerValue
import net.ccbluex.liquidbounce.value.Value

/**
 * Adapting values for obfuscation
 *
 * Script Support
 * @author CCBlueX
 */
class AdaptedValue(private val value : Value<Any>) {

    fun get() : Any = value.get()

    fun getName() : String = value.name

    fun getValue() : Value<Any> = value

    fun set(newValue : Any) {
        if (newValue is Number) {
            if (value is FloatValue) {
                value.set(newValue.toFloat())
            } else if (value is IntegerValue) {
                value.set(newValue.toInt())
            }

            return
        }

        value.set(newValue)
    }
}