package io.github.aerialist7.page

import emotion.styled.styled
import io.github.aerialist7.router.useShowcaseIdParam
import io.github.aerialist7.showcase.Showcase
import js.array.ReadonlyArray
import js.uri.decodeURIComponent
import js.uri.encodeURIComponent
import mui.material.*
import mui.system.Box
import mui.system.sx
import react.*
import react.dom.html.ReactHTML
import react.router.dom.NavLink
import react.router.useLoaderData
import web.cssom.Color
import web.cssom.None
import web.cssom.Position
import web.cssom.px
import mui.icons.material.Menu as MenuIcon

val Sidebar = FC<Props> {
    val isMobile = useIsMobile()
    var isOpen by useState(false)

    Box {
        if (!isMobile) {
            sx {
                gridArea = Area.Sidebar
            }
        }

        component = ReactHTML.nav

        if (isMobile) {
            SwipeableDrawer {
                anchor = DrawerAnchor.left
                open = isOpen
                onOpen = { isOpen = true }
                onClose = { isOpen = false }

                ShowcaseList()
            }

            SpeedDial {
                sx {
                    position = Position.absolute
                    bottom = 80.px
                    left = 16.px
                }

                // TODO: Check without dynamic after override removal in MUI wrappers
                asDynamic().ariaLabel = "Menu"

                icon = MenuIcon.create()
                onClick = { isOpen = true }
            }
        } else {
            Drawer {
                variant = DrawerVariant.permanent
                anchor = DrawerAnchor.left

                ShowcaseList()
            }
        }
    }
}

private val ShowcaseList = FC {
    val showcases = useLoaderData().unsafeCast<ReadonlyArray<Showcase>>()
    val showcaseId = useShowcaseIdParam()

    Box {
        Toolbar()

        List {
            sx {
                width = Sizes.Sidebar.Width
            }

            for ((key, name) in showcases) {
                LinkButton {
                    to = encodeURIComponent(key)

                    ListItemButton {
                        selected = decodeURIComponent(showcaseId) == key

                        ListItemText {
                            primary = ReactNode(name)
                        }
                    }
                }
            }
        }
    }
}

private val LinkButton = NavLink.styled {
    textDecoration = None.none
    color = Color.currentcolor
}
