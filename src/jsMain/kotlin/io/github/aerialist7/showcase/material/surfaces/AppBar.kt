package io.github.aerialist7.showcase.material.surfaces

import mui.icons.material.Menu
import mui.material.*
import mui.material.styles.TypographyVariant.Companion.h6
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import web.cssom.number
import web.cssom.px

val AppBarShowcase = FC<Props> {
    Box {
        sx { flexGrow = number(1.0) }

        AppBar {
            position = AppBarPosition.static

            Toolbar {
                IconButton {
                    sx { marginRight = 2.px }
                    edge = IconButtonEdge.start
                    size = Size.large
                    color = IconButtonColor.inherit
                    ariaLabel = "menu"

                    Menu()
                }

                Typography {
                    sx { flexGrow = number(1.0) }
                    variant = h6
                    component = div

                    +"News"
                }

                Button {
                    color = ButtonColor.inherit

                    +"Login"
                }
            }
        }
    }
}
