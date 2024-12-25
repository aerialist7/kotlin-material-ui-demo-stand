package io.github.aerialist7.showcase.material.data

import io.github.aerialist7.button
import mui.material.Divider
import mui.material.List
import mui.material.ListItem
import mui.material.ListItemText
import react.FC
import react.Props
import react.ReactNode
import react.dom.html.ReactHTML

val DividerShowcase = FC<Props> {
    List {
        component = ReactHTML.nav
        ariaLabel = "mailbox folders"

        ListItem {
            button = true

            ListItemText {
                primary = ReactNode("Inbox")
            }
        }

        Divider()

        ListItem {
            button = true
            divider = true

            ListItemText {
                primary = ReactNode("Drafts")
            }
        }

        ListItem {
            asDynamic().button = true

            ListItemText {
                primary = ReactNode("Trash")
            }
        }

        Divider {
            light = true
        }

        ListItem {
            asDynamic().button = true

            ListItemText {
                primary = ReactNode("Spam")
            }
        }
    }
}
