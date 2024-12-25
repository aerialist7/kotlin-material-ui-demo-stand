package io.github.aerialist7.showcase.material.inputs

import mui.icons.material.VolumeDown
import mui.icons.material.VolumeUp
import mui.material.Slider
import mui.material.Stack
import mui.material.StackDirection.Companion.row
import mui.system.responsive
import mui.system.sx
import react.FC
import react.Props
import react.useState
import web.cssom.AlignItems.Companion.center
import web.cssom.px

val SliderShowcase = FC<Props> {
    var volume by useState<Number>(30)

    Stack {
        sx {
            marginBottom = 1.px
            alignItems = center
        }
        spacing = responsive(2)
        direction = responsive(row)

        VolumeDown()

        Slider {
            ariaLabel = "Volume"
            value = volume
            onChange = { _, newValue, _ -> volume = newValue.unsafeCast<Number>() }
        }

        VolumeUp()
    }

    Slider {
        ariaLabel = "Disabled slider"
        disabled = true
        defaultValue = 30
    }
}
