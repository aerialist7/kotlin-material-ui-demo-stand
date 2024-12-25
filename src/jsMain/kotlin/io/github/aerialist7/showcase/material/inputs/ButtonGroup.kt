package io.github.aerialist7.showcase.material.inputs

import mui.material.Button
import mui.material.ButtonGroup
import mui.material.ButtonGroupVariant
import react.FC
import react.Props

val ButtonGroupShowcase = FC<Props> {
    ButtonGroup {
        variant = ButtonGroupVariant.contained
        ariaLabel = "outlined primary button group"

        Button {
            +"One"
        }

        Button {
            +"Two"
        }

        Button {
            +"Three"
        }
    }
}
