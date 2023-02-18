package team.karakum.components

import csstype.px
import mui.material.Typography
import mui.system.Box
import mui.system.sx
import react.*
import react.dom.html.ReactHTML.main
import react.router.Outlet
import react.router.Route
import react.router.RouteProps
import react.router.Routes
import team.karakum.common.Area

private val DEFAULT_PADDING = 30.px

val Content = FC<Props> {
    val showcases = useContext(ShowcasesContext)

    Routes {
        Route {
            path = "/"
            element = Box.create {
                component = main
                sx {
                    gridArea = Area.Content
                    padding = DEFAULT_PADDING
                }

                Outlet()
            }

            showcases.forEachIndexed { i, (key, _, Component) ->
                Route {
                    index = i == 0
                    path = key
                    element = Component.create()
                }
            }

            Route {
                path = "*"
                element = Typography.create { +"404 Page Not Found" }
            }
        }
    }
}

// TODO: Remove when declarations will be updated
private var RouteProps.index: Boolean
    get() = asDynamic().index
    set(value) {
        asDynamic().index = value
    }

private var RouteProps.element: ReactNode
    get() = asDynamic().element
    set(value) {
        asDynamic().element = value
    }

private var RouteProps.path: String
    get() = asDynamic().path
    set(value) {
        asDynamic().path = value
    }
