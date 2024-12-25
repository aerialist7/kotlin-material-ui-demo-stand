package io.github.aerialist7.showcase.material.navigation

import io.github.aerialist7.color
import mui.material.Breadcrumbs
import mui.material.Link
import mui.material.LinkUnderline
import mui.material.Typography
import react.FC
import react.Props

val BreadcrumbsShowcase = FC<Props> {
    Breadcrumbs {
        ariaLabel = "breadcrumb"

        Link {
            underline = LinkUnderline.hover
            color = "inherit"
            href = "/"

            +"MUI"
        }
        Link {
            underline = LinkUnderline.hover
            color = "inherit"
            href = "/getting-started/installation/"

            +"Core"
        }
        Typography {
            color = "text.primary"

            +"Breadcrumbs"
        }
    }
}
