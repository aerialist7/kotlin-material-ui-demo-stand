package io.github.aerialist7.theme

import mui.material.styles.Theme
import react.*

val ThemeContext: RequiredContext<StateInstance<Theme>> =
    createRequiredContext()

fun useTheme(): Theme =
    useRequired(ThemeContext).component1()

fun useSetTheme(): StateSetter<Theme> =
    useRequired(ThemeContext).component2()
