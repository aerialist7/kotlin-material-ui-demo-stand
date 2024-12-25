package io.github.aerialist7.showcase.material.utils

import mui.material.Box
import mui.material.Button
import mui.material.Modal
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.useState
import web.cssom.*
import web.cssom.LineStyle.Companion.solid

val ModalShowcase = FC<Props> {
    var isOpen by useState(false)

    div {
        Button {
            onClick = { isOpen = true }

            +"Open modal"
        }

        Modal {
            keepMounted = true
            open = isOpen
            onClose = { _, _ -> isOpen = false }

            ariaLabelledBy = "keep-mounted-modal-title"
            ariaDescribedBy = "keep-mounted-modal-description"

            Box {
                sx {
                    position = Position.absolute
                    top = 50.pct
                    left = 50.pct
                    transform = translate(-50.pct, -50.pct)
                    width = 400.px
                    backgroundColor = Color("background.paper")
                    border = Border(2.px, solid, Color("#000"))
                    boxShadow = 24.px.unsafeCast<BoxShadow>()
                    padding = 4.px
                }

                Typography {
                    id = "keep-mounted-modal-title"
                    variant = TypographyVariant.h6
                    component = ReactHTML.h2

                    +"Text in modal"
                }

                Typography {
                    id = "keep-mounted-modal-description"
                    sx {
                        marginTop = 2.px
                    }

                    +"Duis mollis, est non commodo luctus, nisi erat porttitor ligula."
                }
            }
        }
    }
}
