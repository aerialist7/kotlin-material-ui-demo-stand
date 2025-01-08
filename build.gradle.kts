import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                outputFileName = "index.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(kotlinWrappers.react)
                implementation(kotlinWrappers.reactDom)
                implementation(kotlinWrappers.reactRouterDom)

                implementation(kotlinWrappers.emotion)
                implementation(kotlinWrappers.mui.material)
                implementation(kotlinWrappers.mui.iconsMaterial)
                implementation(kotlinWrappers.muix.datePickers)

                implementation(npm("date-fns", "2.30.0"))
                implementation(npm("@date-io/date-fns", "2.17.0"))
            }
        }
    }
}

tasks.withType<KotlinJsCompile>().configureEach {
    compilerOptions {
        target.set("es2015")
    }
}

tasks.wrapper {
    gradleVersion = "8.12"
}
