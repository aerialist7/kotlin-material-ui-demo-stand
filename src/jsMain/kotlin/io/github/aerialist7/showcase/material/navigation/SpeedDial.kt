package io.github.aerialist7.showcase.material.navigation

import mui.material.Box
import mui.material.SpeedDial
import mui.material.SpeedDialAction
import mui.material.SpeedDialIcon
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.create
import web.cssom.Position
import web.cssom.number
import web.cssom.px
import web.cssom.translatez
import mui.icons.material.FileCopy as FileCopyIcon
import mui.icons.material.Print as PrintIcon
import mui.icons.material.Save as SaveIcon
import mui.icons.material.Share as ShareIcon

val SpeedDialShowcase = FC<Props> {
    Box {
        sx {
            height = 320.px
            transform = translatez(0.px)
            flexGrow = number(1.0)
        }

        SpeedDial {
            // TODO: Check without dynamic after override removal in MUI wrappers
            asDynamic().ariaLabel = "SpeedDial basic example"
            sx {
                position = Position.absolute
                bottom = 16.px
                right = 16.px
            }
            icon = SpeedDialIcon.create()


            for ((name, Icon) in actions) {
                SpeedDialAction {
                    key = name
                    icon = Icon.create()
                    tooltipTitle = ReactNode(name)
                }
            }
        }
    }
}

private val actions = arrayOf(
    "Copy" to FileCopyIcon,
    "Save" to SaveIcon,
    "Print" to PrintIcon,
    "Share" to ShareIcon,
)
