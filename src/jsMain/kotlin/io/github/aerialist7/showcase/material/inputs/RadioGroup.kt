package io.github.aerialist7.showcase.material.inputs

import mui.material.*
import react.FC
import react.Props
import react.ReactNode
import react.create
import react.dom.html.ReactHTML.fieldset

val RadioGroupShowcase = FC<Props> {
    FormControl {
        component = fieldset

        FormLabel {
            +"Gender"
        }

        RadioGroup {
            ariaLabel = "gender"
            defaultValue = "female"
            name = "radio-buttons-group"

            FormControlLabel {
                value = "female"
                control = Radio.create()
                label = ReactNode("Female")
            }
            FormControlLabel {
                value = "male"
                control = Radio.create()
                label = ReactNode("Male")
            }
            FormControlLabel {
                value = "other"
                control = Radio.create()
                label = ReactNode("Other")
            }
        }
    }
}
